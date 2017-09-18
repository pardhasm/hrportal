package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the CurrencyTypes database table.
 *
 */
@Entity
@Table(name = "CurrencyTypes")
//@NamedQuery(name="CurrencyType.findAll", query="SELECT c FROM CurrencyType c")
public class CurrencyType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 3)
    private String code;

    @Column(nullable = false, length = 70)
    private String name;

    //bi-directional many-to-one association to EmployeeSalary
    @OneToMany(mappedBy = "currencyType", fetch = FetchType.EAGER)
    private Set<EmployeeSalary> employeeSalaries;

    //bi-directional many-to-one association to PayGrade
    @OneToMany(mappedBy = "currencyType", fetch = FetchType.EAGER)
    private Set<PayGrade> payGrades;

    public CurrencyType() {
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

    public Set<EmployeeSalary> getEmployeeSalaries() {
        return this.employeeSalaries;
    }

    public void setEmployeeSalaries(Set<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

    public EmployeeSalary addEmployeeSalary(EmployeeSalary employeeSalary) {
        getEmployeeSalaries().add(employeeSalary);
        employeeSalary.setCurrencyType(this);

        return employeeSalary;
    }

    public EmployeeSalary removeEmployeeSalary(EmployeeSalary employeeSalary) {
        getEmployeeSalaries().remove(employeeSalary);
        employeeSalary.setCurrencyType(null);

        return employeeSalary;
    }

    public Set<PayGrade> getPayGrades() {
        return this.payGrades;
    }

    public void setPayGrades(Set<PayGrade> payGrades) {
        this.payGrades = payGrades;
    }

    public PayGrade addPayGrade(PayGrade payGrade) {
        getPayGrades().add(payGrade);
        payGrade.setCurrencyType(this);

        return payGrade;
    }

    public PayGrade removePayGrade(PayGrade payGrade) {
        getPayGrades().remove(payGrade);
        payGrade.setCurrencyType(null);

        return payGrade;
    }

}