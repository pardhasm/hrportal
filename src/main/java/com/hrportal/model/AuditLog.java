package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the AuditLog database table.
 */
@Entity
@Table(name = "AuditLog")
//@NamedQuery(name="AuditLog.findAll", query="SELECT a FROM AuditLog a")
public class AuditLog extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Lob
    private String details;

    @Column(length = 300)
    private String employee;

    @Column(length = 100)
    private String ip;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime time;

    @Column(nullable = false, length = 100)
    @NotNull
    private String type;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    @NotNull
    private User userBean;

    public AuditLog() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmployee() {
        return this.employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public DateTime getTime() {
        return this.time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUserBean() {
        return this.userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

}