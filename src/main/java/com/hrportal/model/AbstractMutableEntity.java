package com.hrportal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by pardha on 9/19/17.
 */
@MappedSuperclass
public abstract class AbstractMutableEntity  extends AbstractImmutableEntity {

    private static final long serialVersionUID = 1L;

    @org.hibernate.annotations.Type(type="updatedTime")
    @Basic(optional = true)
    @Column(name = "updated_at", nullable = true)
    private DateTime updatedAt = new DateTime();

//    @Column
//    private Long updatedBy;

    @Version
    @JsonIgnore
    private Long versionId;

    @Column(name = "record_status")
    private RecordStatus recordStatus;

    public AbstractMutableEntity(){
        setRecordStatus(RecordStatus.ACTIVE);
    }

    public DateTime getUpdatedAt() {
        return this.updatedAt;

    }

    public void setUpdatedAt(final DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

//    public Long getUpdatedBy() {
//        return this.updatedBy;
//
//    }
//
//    public void setUpdatedBy(final Long updatedBy) {
//        this.updatedBy = updatedBy;
//    }

    public Long getVersionId() {
        return this.versionId;

    }

    public void setVersionId(final Long versionId) {
        this.versionId = versionId;
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
        //result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
        result = prime * result + ((versionId == null) ? 0 : versionId.hashCode());
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
        AbstractMutableEntity other = (AbstractMutableEntity) obj;
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
//        if (updatedBy == null) {
//            if (other.updatedBy != null)
//                return false;
//        } else if (!updatedBy.equals(other.updatedBy))
//            return false;
        if (versionId == null) {
            if (other.versionId != null)
                return false;
        } else if (!versionId.equals(other.versionId))
            return false;
        return true;
    }

}
