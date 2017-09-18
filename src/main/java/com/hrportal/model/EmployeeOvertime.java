package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the EmployeeOvertime database table.
 */
@Entity
@Table(name = "EmployeeOvertime")
//@NamedQuery(name="EmployeeOvertime.findAll", query="SELECT e FROM EmployeeOvertime e")
public class EmployeeOvertime implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    private Date endTime;

    @Lob
    private String notes;

    private Long project;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    private Date startTime;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Approval status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    //bi-directional many-to-one association to OvertimeCategory
    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private OvertimeCategory overtimeCategory;

    public EmployeeOvertime() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
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

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Approval getStatus() {
        return this.status;
    }

    public void setStatus(Approval status) {
        this.status = status;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

    public OvertimeCategory getOvertimeCategory() {
        return this.overtimeCategory;
    }

    public void setOvertimeCategory(OvertimeCategory overtimeCategory) {
        this.overtimeCategory = overtimeCategory;
    }

}