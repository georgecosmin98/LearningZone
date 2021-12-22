package com.jooq.model;

import com.jooq.jooq.tables.pojos.Country;
import com.jooq.jooq.tables.pojos.Unrepresentative;

public class CountryRepresentativeMapper {
    private Country country;
    private Unrepresentative unrepresentative;

    public CountryRepresentativeMapper(Country country, Unrepresentative unrepresentative) {
        this.country = country;
        this.unrepresentative = unrepresentative;
    }

    public CountryRepresentativeMapper() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Unrepresentative getUnrepresentative() {
        return unrepresentative;
    }

    public void setUnrepresentative(Unrepresentative unrepresentative) {
        this.unrepresentative = unrepresentative;
    }
}
