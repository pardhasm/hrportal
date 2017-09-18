package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the EmployeeSalary database table.
 */
@Entity
@Table(name = "EmployeeSalary")
//@NamedQuery(name="EmployeeSalary.findAll", query="SELECT e FROM EmployeeSalary e")
public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private BigInteger component;

    @Lob
    private String details;

    @Column(name = "pay_frequency", length = 20)
    private String payFrequency;

    //bi-directional many-to-one association to CurrencyType
    @ManyToOne
    @JoinColumn(name = "currency")
    private CurrencyType currencyType;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    public EmployeeSalary() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getComponent() {
        return this.component;
    }

    public void setComponent(BigInteger component) {
        this.component = component;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPayFrequency() {
        return this.payFrequency;
    }

    public void setPayFrequency(String payFrequency) {
        this.payFrequency = payFrequency;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

}