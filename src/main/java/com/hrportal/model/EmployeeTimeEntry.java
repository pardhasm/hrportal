package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeTimeEntry database table.
 */
@Entity
@Table(name = "EmployeeTimeEntry")
//@NamedQuery(name="EmployeeTimeEntry.findAll", query="SELECT e FROM EmployeeTimeEntry e")
public class EmployeeTimeEntry extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name = "date_end")
    private DateTime dateEnd;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name = "date_start")
    private DateTime dateStart;

    @Lob
    private String details;

    @Column(name = "time_end", nullable = false, length = 10)
    @NotNull
    private String timeEnd;

    @Column(name = "time_start", nullable = false, length = 10)
    @NotNull
    private String timeStart;

    //bi-directional many-to-one association to EmployeeTimeSheet
    @ManyToOne
    @JoinColumn(name = "timesheet", nullable = false)
    @NotNull
    private EmployeeTimeSheet employeeTimeSheet;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    @NotNull
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

    public DateTime getCreated() {
        return this.created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(DateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public DateTime getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(DateTime dateStart) {
        this.dateStart = dateStart;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
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