/*
 * This file is generated by jOOQ.
 */
package com.jooq.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pkCountryId;
    private String  name;
    private String  officiallang;
    private Integer size;

    public Country() {}

    public Country(Country value) {
        this.pkCountryId = value.pkCountryId;
        this.name = value.name;
        this.officiallang = value.officiallang;
        this.size = value.size;
    }

    public Country(
        Integer pkCountryId,
        String  name,
        String  officiallang,
        Integer size
    ) {
        this.pkCountryId = pkCountryId;
        this.name = name;
        this.officiallang = officiallang;
        this.size = size;
    }

    /**
     * Getter for <code>jooq_tutorial.country.Pk_Country_Id</code>.
     */
    public Integer getPkCountryId() {
        return this.pkCountryId;
    }

    /**
     * Setter for <code>jooq_tutorial.country.Pk_Country_Id</code>.
     */
    public Country setPkCountryId(Integer pkCountryId) {
        this.pkCountryId = pkCountryId;
        return this;
    }

    /**
     * Getter for <code>jooq_tutorial.country.Name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>jooq_tutorial.country.Name</code>.
     */
    public Country setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>jooq_tutorial.country.Officiallang</code>.
     */
    public String getOfficiallang() {
        return this.officiallang;
    }

    /**
     * Setter for <code>jooq_tutorial.country.Officiallang</code>.
     */
    public Country setOfficiallang(String officiallang) {
        this.officiallang = officiallang;
        return this;
    }

    /**
     * Getter for <code>jooq_tutorial.country.Size</code>.
     */
    public Integer getSize() {
        return this.size;
    }

    /**
     * Setter for <code>jooq_tutorial.country.Size</code>.
     */
    public Country setSize(Integer size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Country other = (Country) obj;
        if (pkCountryId == null) {
            if (other.pkCountryId != null)
                return false;
        }
        else if (!pkCountryId.equals(other.pkCountryId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (officiallang == null) {
            if (other.officiallang != null)
                return false;
        }
        else if (!officiallang.equals(other.officiallang))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        }
        else if (!size.equals(other.size))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.pkCountryId == null) ? 0 : this.pkCountryId.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.officiallang == null) ? 0 : this.officiallang.hashCode());
        result = prime * result + ((this.size == null) ? 0 : this.size.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Country (");

        sb.append(pkCountryId);
        sb.append(", ").append(name);
        sb.append(", ").append(officiallang);
        sb.append(", ").append(size);

        sb.append(")");
        return sb.toString();
    }
}
