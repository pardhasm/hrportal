package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the Attendance database table.
 */
@Entity
@Table(name = "Attendance")
//@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name = "in_time")
    private DateTime inTime;

    @Column(length = 500)
    private String note;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name = "out_time")
    private DateTime outTime;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    @NotNull
    private Employee employeeBean;

    public Attendance() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getInTime() {
        return this.inTime;
    }

    public void setInTime(DateTime inTime) {
        this.inTime = inTime;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DateTime getOutTime() {
        return this.outTime;
    }

    public void setOutTime(DateTime outTime) {
        this.outTime = outTime;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

}