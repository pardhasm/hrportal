package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the Province database table.
 *
 */
@Entity
@Table(name = "Province")
//@NamedQuery(name="Province.findAll", query="SELECT p FROM Province p")
public class Province extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 2)
    private String code;

    @Column(nullable = false, length = 40)
    private String name;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "provinceBean", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    //bi-directional many-to-one association to Country
    @ManyToOne
    @JoinColumn(name = "country", nullable = false)
    @NotNull
    private Country countryBean;

    public Province() {
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
        employee.setProvinceBean(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setProvinceBean(null);

        return employee;
    }

    public Country getCountryBean() {
        return this.countryBean;
    }

    public void setCountryBean(Country countryBean) {
        this.countryBean = countryBean;
    }

}