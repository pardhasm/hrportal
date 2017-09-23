package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeOvertime database table.
 */
@Entity
@Table(name = "EmployeeOvertime")
//@NamedQuery(name="EmployeeOvertime.findAll", query="SELECT e FROM EmployeeOvertime e")
public class EmployeeOvertime extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name = "end_time")
    private DateTime endTime;

    @Lob
    private String notes;

    private Long project;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name = "start_time")
    private DateTime startTime;

    @Column(length = 20, name = "status")
    @Enumerated(EnumType.STRING)
    private Approval approvalStatus;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    @NotNull
    private Employee employeeBean;

    //bi-directional many-to-one association to OvertimeCategory
    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    @NotNull
    private OverTimeCategory overtimeCategory;

    public EmployeeOvertime() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getEndTime() {
        return this.endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getProject() {
        return this.project;
    }

    public void setProject(Long project) {
        this.project = project;
    }

    public DateTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public Approval getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Approval approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

    public OverTimeCategory getOvertimeCategory() {
        return this.overtimeCategory;
    }

    public void setOvertimeCategory(OverTimeCategory overtimeCategory) {
        this.overtimeCategory = overtimeCategory;
    }

    public void setOverTimeCategory(OverTimeCategory overtimeCategory) {
        this.overtimeCategory = overtimeCategory;
    }

}