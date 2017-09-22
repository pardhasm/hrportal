package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the JobTitles database table.
 *
 */
@Entity
@Table(name = "JobTitles")
//@NamedQuery(name="JobTitle.findAll", query="SELECT j FROM JobTitle j")
public class JobTitle extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 10)
    @NotNull
    private String code;

    @Column(length = 200)
    private String description;

    @Column(length = 100)
    private String name;

    @Column(length = 400)
    private String specification;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "jobTitleBean", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public JobTitle() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getSpecification() {
        return this.specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setJobTitleBean(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setJobTitleBean(null);

        return employee;
    }

}