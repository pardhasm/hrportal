package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "in_time")
    private Date inTime;

    @Column(length = 500)
    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "out_time")
    private Date outTime;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    public Attendance() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInTime() {
        return this.inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOutTime() {
        return this.outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

}