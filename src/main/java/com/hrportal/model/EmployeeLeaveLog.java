package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the EmployeeLeaveLog database table.
 */
@Entity
@Table(name = "EmployeeLeaveLog")
//@NamedQuery(name="EmployeeLeaveLog.findAll", query="SELECT e FROM EmployeeLeaveLog e")
public class EmployeeLeaveLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(nullable = false, length = 500)
    private String data;

    @Column(name = "status_from", length = 20)
    private String statusFrom;

    @Column(name = "status_to", length = 20)
    private String statusTo;

    //bi-directional many-to-one association to EmployeeLeave
    @ManyToOne
    @JoinColumn(name = "employee_leave", nullable = false)
    private EmployeeLeave employeeLeaveBean;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public EmployeeLeaveLog() {
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

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatusFrom() {
        return this.statusFrom;
    }

    public void setStatusFrom(String statusFrom) {
        this.statusFrom = statusFrom;
    }

    public String getStatusTo() {
        return this.statusTo;
    }

    public void setStatusTo(String statusTo) {
        this.statusTo = statusTo;
    }

    public EmployeeLeave getEmployeeLeaveBean() {
        return this.employeeLeaveBean;
    }

    public void setEmployeeLeaveBean(EmployeeLeave employeeLeaveBean) {
        this.employeeLeaveBean = employeeLeaveBean;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}