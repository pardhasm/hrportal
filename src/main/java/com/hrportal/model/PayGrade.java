package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the PayGrades database table.
 *
 */
@Entity
@Table(name = "PayGrades")
//@NamedQuery(name="PayGrade.findAll", query="SELECT p FROM PayGrade p")
public class PayGrade extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "max_salary", precision = 10, scale = 2)
    private BigDecimal maxSalary;

    @Column(name = "min_salary", precision = 10, scale = 2)
    private BigDecimal minSalary;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "payGradeBean", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    //bi-directional many-to-one association to CurrencyType
    @ManyToOne
    @JoinColumn(name = "currency", nullable = false)
    private CurrencyType currencyType;

    public PayGrade() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public BigDecimal getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
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
        employee.setPayGradeBean(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setPayGradeBean(null);

        return employee;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

}