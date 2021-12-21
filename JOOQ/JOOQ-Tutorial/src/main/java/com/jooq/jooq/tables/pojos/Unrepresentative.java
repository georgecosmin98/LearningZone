/*
 * This file is generated by jOOQ.
 */
package com.jooq.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Unrepresentative implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pkUnrepresentativeId;
    private String  name;
    private String  gender;
    private Integer fkCountryId;

    public Unrepresentative() {}

    public Unrepresentative(Unrepresentative value) {
        this.pkUnrepresentativeId = value.pkUnrepresentativeId;
        this.name = value.name;
        this.gender = value.gender;
        this.fkCountryId = value.fkCountryId;
    }

    public Unrepresentative(
        Integer pkUnrepresentativeId,
        String  name,
        String  gender,
        Integer fkCountryId
    ) {
        this.pkUnrepresentativeId = pkUnrepresentativeId;
        this.name = name;
        this.gender = gender;
        this.fkCountryId = fkCountryId;
    }

    /**
     * Getter for
     * <code>jooq_tutorial.unrepresentative.Pk_UNrepresentative_Id</code>.
     */
    public Integer getPkUnrepresentativeId() {
        return this.pkUnrepresentativeId;
    }

    /**
     * Setter for
     * <code>jooq_tutorial.unrepresentative.Pk_UNrepresentative_Id</code>.
     */
    public Unrepresentative setPkUnrepresentativeId(Integer pkUnrepresentativeId) {
        this.pkUnrepresentativeId = pkUnrepresentativeId;
        return this;
    }

    /**
     * Getter for <code>jooq_tutorial.unrepresentative.Name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>jooq_tutorial.unrepresentative.Name</code>.
     */
    public Unrepresentative setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>jooq_tutorial.unrepresentative.Gender</code>.
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Setter for <code>jooq_tutorial.unrepresentative.Gender</code>.
     */
    public Unrepresentative setGender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Getter for <code>jooq_tutorial.unrepresentative.Fk_Country_Id</code>.
     */
    public Integer getFkCountryId() {
        return this.fkCountryId;
    }

    /**
     * Setter for <code>jooq_tutorial.unrepresentative.Fk_Country_Id</code>.
     */
    public Unrepresentative setFkCountryId(Integer fkCountryId) {
        this.fkCountryId = fkCountryId;
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
        final Unrepresentative other = (Unrepresentative) obj;
        if (pkUnrepresentativeId == null) {
            if (other.pkUnrepresentativeId != null)
                return false;
        }
        else if (!pkUnrepresentativeId.equals(other.pkUnrepresentativeId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        }
        else if (!name.equals(other.name))
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        }
        else if (!gender.equals(other.gender))
            return false;
        if (fkCountryId == null) {
            if (other.fkCountryId != null)
                return false;
        }
        else if (!fkCountryId.equals(other.fkCountryId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.pkUnrepresentativeId == null) ? 0 : this.pkUnrepresentativeId.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.gender == null) ? 0 : this.gender.hashCode());
        result = prime * result + ((this.fkCountryId == null) ? 0 : this.fkCountryId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Unrepresentative (");

        sb.append(pkUnrepresentativeId);
        sb.append(", ").append(name);
        sb.append(", ").append(gender);
        sb.append(", ").append(fkCountryId);

        sb.append(")");
        return sb.toString();
    }
}