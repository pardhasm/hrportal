package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * The persistent class for the LeaveStartingBalance database table.
 */
@Entity
@Table(name = "LeaveStartingBalance")
//@NamedQuery(name="LeaveStartingBalance.findAll", query="SELECT l FROM LeaveStartingBalance l")
public class LeaveStartingBalance extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 3)
    private BigDecimal amount;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    private Long employee;

    @Column(name = "leave_period", nullable = false)
    @NotNull
    private Long leavePeriod;

    @Column(name = "leave_type", nullable = false)
    @NotNull
    private Long leaveType;

    @Lob
    private String note;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

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

    public DateTime getCreated() {
        return this.created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public Long getEmployee() {
        return this.employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getLeavePeriod() {
        return this.leavePeriod;
    }

    public void setLeavePeriod(Long leavePeriod) {
        this.leavePeriod = leavePeriod;
    }

    public Long getLeaveType() {
        return this.leaveType;
    }

    public void setLeaveType(Long leaveType) {
        this.leaveType = leaveType;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

}