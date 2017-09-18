package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;


/**
 * The persistent class for the LeaveStartingBalance database table.
 */
@Entity
@Table(name = "LeaveStartingBalance")
//@NamedQuery(name="LeaveStartingBalance.findAll", query="SELECT l FROM LeaveStartingBalance l")
public class LeaveStartingBalance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private BigInteger employee;

    @Column(name = "leave_period", nullable = false)
    private BigInteger leavePeriod;

    @Column(name = "leave_type", nullable = false)
    private BigInteger leaveType;

    @Lob
    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public LeaveStartingBalance() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BigInteger getEmployee() {
        return this.employee;
    }

    public void setEmployee(BigInteger employee) {
        this.employee = employee;
    }

    public BigInteger getLeavePeriod() {
        return this.leavePeriod;
    }

    public void setLeavePeriod(BigInteger leavePeriod) {
        this.leavePeriod = leavePeriod;
    }

    public BigInteger getLeaveType() {
        return this.leaveType;
    }

    public void setLeaveType(BigInteger leaveType) {
        this.leaveType = leaveType;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}