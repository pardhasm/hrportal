package com.hrportal.model;


import com.hrportal.constants.APIConstants;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;

/**
 * Created by radhamohan on 25/04/17.
 */
@MappedSuperclass
public abstract class AbstractMutableEntityWithOutVersion extends AbstractImmutatableEntity {

    private static final long serialVersionUID = 1L;

    @Type(type = "updatedTime")
    @Basic(optional = false)
    @Column(name = "updated_at", nullable = false)
    private DateTime updatedAt;

    @Column
    private Long updatedBy;

    @Column
    private RecordStatus recordStatus;

    public AbstractMutableEntityWithOutVersion() {
        setRecordStatus(RecordStatus.ACTIVE);
    }

    public DateTime getUpdatedAt() {
        return this.updatedAt;

    }

    public void setUpdatedAt(final DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return this.updatedBy;

    }

    public void setUpdatedBy(final Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((recordStatus == null) ? 0 : recordStatus.hashCode());
        result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
        result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
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
        AbstractMutableEntityWithOutVersion other = (AbstractMutableEntityWithOutVersion) obj;
        if (recordStatus == null) {
            if (other.recordStatus != null)
                return false;
        } else if (!recordStatus.equals(other.recordStatus))
            return false;
        if (updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        } else if (!updatedAt.equals(other.updatedAt))
            return false;
        if (updatedBy == null) {
            if (other.updatedBy != null)
                return false;
        } else if (!updatedBy.equals(other.updatedBy))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AbstractMutableEntityWithOutVersion [updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + ", recordStatus="
                + recordStatus + ", toString()=" + super.toString() + "]";
    }

    @PrePersist
    public void onPersist() {
        DateTime dateTime = DateTime.now(DateTimeZone.forID(APIConstants.TIME_ZONE_ID));
        this.setCreatedAt(dateTime);
        this.setUpdatedAt(dateTime);
    }

    @PreUpdate
    public void update() {
        DateTime dateTime = DateTime.now(DateTimeZone.forID(APIConstants.TIME_ZONE_ID));
        this.setUpdatedAt(dateTime);
    }

}
