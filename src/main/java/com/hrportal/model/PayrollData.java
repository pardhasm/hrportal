package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



/**
 * The persistent class for the PayrollData database table.
 */
@Entity
@Table(name = "PayrollData")
//@NamedQuery(name="PayrollData.findAll", query="SELECT p FROM PayrollData p")
public class PayrollData extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 25)
    private String amount;

    @Column(nullable = false)
    @NotNull
    private Long employee;

    @Column(name = "payroll_item", nullable = false)
    @NotNull
    private int payrollItem;

    //bi-directional many-to-one association to Payroll
    @ManyToOne
    @JoinColumn(name = "payroll", nullable = false)
    @NotNull
    private Payroll payrollBean;

    public PayrollData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getEmployee() {
        return this.employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public int getPayrollItem() {
        return this.payrollItem;
    }

    public void setPayrollItem(int payrollItem) {
        this.payrollItem = payrollItem;
    }

    public Payroll getPayrollBean() {
        return this.payrollBean;
    }

    public void setPayrollBean(Payroll payrollBean) {
        this.payrollBean = payrollBean;
    }

}