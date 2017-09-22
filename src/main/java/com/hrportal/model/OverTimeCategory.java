package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the OvertimeCategories database table.
 *
 */
@Entity
@Table(name = "OvertimeCategories")
//@NamedQuery(name="OverTimeCategoryRepository.findAll", query="SELECT o FROM OverTimeCategoryRepository o")
public class OverTimeCategory extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @Column(nullable = false, length = 500)
    private String name;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

    //bi-directional many-to-one association to EmployeeOvertime
    @OneToMany(mappedBy = "overtimeCategory", fetch = FetchType.EAGER)
    private Set<EmployeeOvertime> employeeOvertimes;

    public OverTimeCategory() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(DateTime updated) {
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
        employeeOvertime.setOverTimeCategory(this);

        return employeeOvertime;
    }

    public EmployeeOvertime removeEmployeeOvertime(EmployeeOvertime employeeOvertime) {
        getEmployeeOvertimes().remove(employeeOvertime);
        employeeOvertime.setOverTimeCategory(null);

        return employeeOvertime;
    }

}