package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the EmployeeTimeEntry database table.
 */
@Entity
@Table(name = "EmployeeTimeEntry")
//@NamedQuery(name="EmployeeTimeEntry.findAll", query="SELECT e FROM EmployeeTimeEntry e")
public class EmployeeTimeEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_end")
    private Date dateEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_start")
    private Date dateStart;

    @Lob
    private String details;

    @Column(length = 20)
    private String status;

    @Column(name = "time_end", nullable = false, length = 10)
    private String timeEnd;

    @Column(name = "time_start", nullable = false, length = 10)
    private String timeStart;

    //bi-directional many-to-one association to EmployeeTimeSheet
    @ManyToOne
    @JoinColumn(name = "timesheet", nullable = false)
    private EmployeeTimeSheet employeeTimeSheet;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    //bi-directional many-to-one association to Project
    @ManyToOne
    @JoinColumn(name = "project")
    private Project projectBean;

    public EmployeeTimeEntry() {
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

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeEnd() {
        return this.timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return this.timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public EmployeeTimeSheet getEmployeeTimeSheet() {
        return this.employeeTimeSheet;
    }

    public void setEmployeeTimeSheet(EmployeeTimeSheet employeeTimeSheet) {
        this.employeeTimeSheet = employeeTimeSheet;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

    public Project getProjectBean() {
        return this.projectBean;
    }

    public void setProjectBean(Project projectBean) {
        this.projectBean = projectBean;
    }

}