package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the EmployeeDataHistory database table.
 */
@Entity
@Table(name = "EmployeeDataHistory")
//@NamedQuery(name="EmployeeDataHistory.findAll", query="SELECT e FROM EmployeeDataHistory e")
public class EmployeeDataHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(length = 800)
    private String description;

    @Column(nullable = false, length = 100)
    private String field;

    @Column(name = "new_value", length = 500)
    private String newValue;

    @Column(name = "old_value", length = 500)
    private String oldValue;

    @Column(nullable = false, length = 100)
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name = "user")
    private User userBean;

    public EmployeeDataHistory() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getNewValue() {
        return this.newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return this.oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public User getUserBean() {
        return this.userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

}