package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the OvertimeCategories database table.
 *
 */
@Entity
@Table(name = "OvertimeCategories")
//@NamedQuery(name="OvertimeCategory.findAll", query="SELECT o FROM OvertimeCategory o")
public class OvertimeCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(nullable = false, length = 500)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    //bi-directional many-to-one association to EmployeeOvertime
    @OneToMany(mappedBy = "overtimeCategory", fetch = FetchType.EAGER)
    private Set<EmployeeOvertime> employeeOvertimes;

    public OvertimeCategory() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdated() {
        return this.updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<EmployeeOvertime> getEmployeeOvertimes() {
        return this.employeeOvertimes;
    }

    public void setEmployeeOvertimes(Set<EmployeeOvertime> employeeOvertimes) {
        this.employeeOvertimes = employeeOvertimes;
    }

    public EmployeeOvertime addEmployeeOvertime(EmployeeOvertime employeeOvertime) {
        getEmployeeOvertimes().add(employeeOvertime);
        employeeOvertime.setOvertimeCategory(this);

        return employeeOvertime;
    }

    public EmployeeOvertime removeEmployeeOvertime(EmployeeOvertime employeeOvertime) {
        getEmployeeOvertimes().remove(employeeOvertime);
        employeeOvertime.setOvertimeCategory(null);

        return employeeOvertime;
    }

}