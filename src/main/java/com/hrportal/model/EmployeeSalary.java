package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;



/**
 * The persistent class for the EmployeeSalary database table.
 */
@Entity
@Table(name = "EmployeeSalary")
//@NamedQuery(name="EmployeeSalary.findAll", query="SELECT e FROM EmployeeSalary e")
public class EmployeeSalary extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private Long component;

    @Lob
    private String details;

    @Column(name = "pay_frequency", length = 20)
    private PayFrequency payFrequency;

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

    public Long getComponent() {
        return this.component;
    }

    public void setComponent(Long component) {
        this.component = component;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public PayFrequency getPayFrequency() {
        return this.payFrequency;
    }

    public void setPayFrequency(PayFrequency payFrequency) {
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