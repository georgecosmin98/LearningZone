package com.jooq.service;

import com.jooq.jooq.Tables;
import com.jooq.jooq.tables.pojos.Country;
import com.jooq.jooq.tables.pojos.Unrepresentative;
import com.jooq.model.InnerJoinMapper;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jooq.jooq.Tables.*;

import java.util.List;

@Service
public class JooqTutorialService {

    @Autowired
    DSLContext dslContext;

    public List<Country> getCountries(){
        return dslContext.selectFrom(Tables.COUNTRY)
                .fetchInto(Country.class);
    }

    public List<Unrepresentative> getUnrepresentatives(){
        return dslContext.selectFrom(Tables.UNREPRESENTATIVE)
                .fetchInto(Unrepresentative.class);
    }

    public List<InnerJoinMapper> getInnerJoin(){
        return dslContext.select()
                .from(Tables.COUNTRY)
                .join(Tables.UNREPRESENTATIVE)
                .on(Tables.COUNTRY.PK_COUNTRY_ID.eq(Tables.UNREPRESENTATIVE.FK_COUNTRY_ID))
                .fetch().into(InnerJoinMapper.class);
    }

    public List<InnerJoinMapper> getLeftJoin(){
        return dslContext.select()
                .from(Tables.COUNTRY)
                .leftJoin(Tables.UNREPRESENTATIVE)
                .on(Tables.COUNTRY.PK_COUNTRY_ID.eq(Tables.UNREPRESENTATIVE.FK_COUNTRY_ID))
                .fetch().into(InnerJoinMapper.class);
    }

    public List<InnerJoinMapper> getRightJoin(){
        return dslContext.select()
                .from(Tables.COUNTRY)
                .rightJoin(Tables.UNREPRESENTATIVE)
                .on(Tables.COUNTRY.PK_COUNTRY_ID.eq(Tables.UNREPRESENTATIVE.FK_COUNTRY_ID))
                .fetch().into(InnerJoinMapper.class);
    }

    public int saveCountry(Country country){
        return dslContext.transactionResult(configuration ->
        {
            int result;
            result = DSL.using(configuration)
                    .insertInto(COUNTRY,COUNTRY.NAME,COUNTRY.OFFICIALLANG,COUNTRY.SIZE)
                    .values(country.getName(), country.getOfficiallang(),country.getSize())
                    .returning()
                    .execute();
            return result;
        });
    }

    public int saveCountryThenSaveUnrepresentative(Country country, Unrepresentative unrepresentative){
        return dslContext.transactionResult(configuration ->
        {
            int result = 0;
            result += DSL.using(configuration)
                    .insertInto(COUNTRY,COUNTRY.NAME,COUNTRY.OFFICIALLANG,COUNTRY.SIZE)
                    .values(country.getName(), country.getOfficiallang(),country.getSize())
                    .returning()
                    .execute();

//  Throwing exception to be able to verify if transaction work
            result --;
            result = result/0;

            result += DSL.using(configuration)
                    .insertInto(UNREPRESENTATIVE,UNREPRESENTATIVE.NAME,UNREPRESENTATIVE.GENDER,UNREPRESENTATIVE.FK_COUNTRY_ID)
                    .values(unrepresentative.getName(), unrepresentative.getGender(), unrepresentative.getFkCountryId())
                    .returning()
                    .execute();

            return result;
        });
    }
}
