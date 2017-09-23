package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeLeaveLog database table.
 */
@Entity
@Table(name = "EmployeeLeaveLog")
//@NamedQuery(name="EmployeeLeaveLog.findAll", query="SELECT e FROM EmployeeLeaveLog e")
public class EmployeeLeaveLog extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @Column(nullable = false, length = 500)
    private String data;

    @Column(name = "status_from", length = 20)
    @Enumerated(EnumType.STRING)
    private Approval statusFrom;

    @Column(name = "status_to", length = 20)
    @Enumerated(EnumType.STRING)
    private Approval statusTo;

    //bi-directional many-to-one association to EmployeeLeave
    @ManyToOne
    @JoinColumn(name = "employee_leave", nullable = false)
    @NotNull
    private EmployeeLeave employeeLeaveBean;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public EmployeeLeaveLog() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
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

    public Approval getStatusFrom() {
        return statusFrom;
    }

    public void setStatusFrom(Approval statusFrom) {
        this.statusFrom = statusFrom;
    }

    public Approval getStatusTo() {
        return statusTo;
    }

    public void setStatusTo(Approval statusTo) {
        this.statusTo = statusTo;
    }
}