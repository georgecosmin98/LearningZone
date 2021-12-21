package com.jooq.service;

import com.jooq.jooq.Tables;
import com.jooq.jooq.tables.pojos.Country;
import com.jooq.jooq.tables.pojos.Unrepresentative;
import com.jooq.model.InnerJoinMapper;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
