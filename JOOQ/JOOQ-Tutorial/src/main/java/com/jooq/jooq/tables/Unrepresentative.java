/*
 * This file is generated by jOOQ.
 */
package com.jooq.jooq.tables;


import com.jooq.jooq.Indexes;
import com.jooq.jooq.JooqTutorial;
import com.jooq.jooq.Keys;
import com.jooq.jooq.tables.records.UnrepresentativeRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Unrepresentative extends TableImpl<UnrepresentativeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>jooq_tutorial.unrepresentative</code>
     */
    public static final Unrepresentative UNREPRESENTATIVE = new Unrepresentative();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UnrepresentativeRecord> getRecordType() {
        return UnrepresentativeRecord.class;
    }

    /**
     * The column
     * <code>jooq_tutorial.unrepresentative.Pk_UNrepresentative_Id</code>.
     */
    public final TableField<UnrepresentativeRecord, Integer> PK_UNREPRESENTATIVE_ID = createField(DSL.name("Pk_UNrepresentative_Id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>jooq_tutorial.unrepresentative.Name</code>.
     */
    public final TableField<UnrepresentativeRecord, String> NAME = createField(DSL.name("Name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>jooq_tutorial.unrepresentative.Gender</code>.
     */
    public final TableField<UnrepresentativeRecord, String> GENDER = createField(DSL.name("Gender"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>jooq_tutorial.unrepresentative.Fk_Country_Id</code>.
     */
    public final TableField<UnrepresentativeRecord, Integer> FK_COUNTRY_ID = createField(DSL.name("Fk_Country_Id"), SQLDataType.INTEGER, this, "");

    private Unrepresentative(Name alias, Table<UnrepresentativeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Unrepresentative(Name alias, Table<UnrepresentativeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>jooq_tutorial.unrepresentative</code> table
     * reference
     */
    public Unrepresentative(String alias) {
        this(DSL.name(alias), UNREPRESENTATIVE);
    }

    /**
     * Create an aliased <code>jooq_tutorial.unrepresentative</code> table
     * reference
     */
    public Unrepresentative(Name alias) {
        this(alias, UNREPRESENTATIVE);
    }

    /**
     * Create a <code>jooq_tutorial.unrepresentative</code> table reference
     */
    public Unrepresentative() {
        this(DSL.name("unrepresentative"), null);
    }

    public <O extends Record> Unrepresentative(Table<O> child, ForeignKey<O, UnrepresentativeRecord> key) {
        super(child, key, UNREPRESENTATIVE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : JooqTutorial.JOOQ_TUTORIAL;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.UNREPRESENTATIVE_FK_COUNTRY_ID);
    }

    @Override
    public Identity<UnrepresentativeRecord, Integer> getIdentity() {
        return (Identity<UnrepresentativeRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<UnrepresentativeRecord> getPrimaryKey() {
        return Keys.KEY_UNREPRESENTATIVE_PRIMARY;
    }

    @Override
    public List<ForeignKey<UnrepresentativeRecord, ?>> getReferences() {
        return Arrays.asList(Keys.UNREPRESENTATIVE_IBFK_1);
    }

    private transient Country _country;

    public Country country() {
        if (_country == null)
            _country = new Country(this, Keys.UNREPRESENTATIVE_IBFK_1);

        return _country;
    }

    @Override
    public Unrepresentative as(String alias) {
        return new Unrepresentative(DSL.name(alias), this);
    }

    @Override
    public Unrepresentative as(Name alias) {
        return new Unrepresentative(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Unrepresentative rename(String name) {
        return new Unrepresentative(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Unrepresentative rename(Name name) {
        return new Unrepresentative(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
