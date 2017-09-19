package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the Nationality database table.
 *
 */
@Entity
@Table(name = "Nationality")
//@NamedQuery(name="Nationality.findAll", query="SELECT n FROM Nationality n")
public class Nationality extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "nationalityBean", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Nationality() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
        employee.setNationalityBean(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setNationalityBean(null);

        return employee;
    }

}