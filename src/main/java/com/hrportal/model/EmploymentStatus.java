package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the EmploymentStatus database table.
 *
 */
@Entity
@Table(name = "EmploymentStatus")
//@NamedQuery(name="EmploymentStatus.findAll", query="SELECT e FROM EmploymentStatus e")
public class EmploymentStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 400)
    private String description;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "employmentStatusBean", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public EmploymentStatus() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setEmploymentStatusBean(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setEmploymentStatusBean(null);

        return employee;
    }

}