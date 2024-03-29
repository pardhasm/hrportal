package com.hrportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by pardha on 9/19/17.
 */
@TypeDef(name = "updatedTime", typeClass = org.jadira.usertype.dateandtime.joda.PersistentDateTime.class, parameters = {
        @Parameter(value = "Asia/Kolkata", name = "databaseZone"), @Parameter(value = "Asia/Kolkata", name = "javaZone") })
@MappedSuperclass
@JsonIgnoreProperties("classType")
public abstract class AbstractImmutableEntity extends BaseEntity {

    /**
     * Serialization version ID
     */
    private static final long serialVersionUID = 1L;

    @org.hibernate.annotations.Type(type="updatedTime")
    @Column()
    private DateTime createdAt = new DateTime();


    /**
     * Return the value associated with the column: createdAt.
     *
     * @return A DateTime object (this.createdAt)
     */
    public DateTime getCreatedAt() {
        return this.createdAt;

    }

    /**
     * Set the value related to the column: createdAt.
     *
     * @param createdAt
     *          the createdAt value you wish to set
     */
    public void setCreatedAt(final DateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Return the value associated with the column: createdBy.
     *
     * @return A Long object (this.createdBy)
     */
//    public Long getCreatedBy() {
//        return this.createdBy;
//
//    }


//    public void setCreatedBy(final Long createdBy) {
//        this.createdBy = createdBy;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        //result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractImmutableEntity other = (AbstractImmutableEntity) obj;
        if (createdAt == null) {
            if (other.createdAt != null)
                return false;
        } else if (!createdAt.equals(other.createdAt))
            return false;
//        if (createdBy == null) {
//            if (other.createdBy != null)
//                return false;
//        } else if (!createdBy.equals(other.createdBy))
//            return false;
        return true;
    }


}
