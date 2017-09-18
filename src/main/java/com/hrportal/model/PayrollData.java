package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;



/**
 * The persistent class for the PayrollData database table.
 */
@Entity
@Table(name = "PayrollData")
//@NamedQuery(name="PayrollData.findAll", query="SELECT p FROM PayrollData p")
public class PayrollData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(length = 25)
    private String amount;

    @Column(nullable = false)
    private Long employee;

    @Column(name = "payroll_item", nullable = false)
    private int payrollItem;

    //bi-directional many-to-one association to Payroll
    @ManyToOne
    @JoinColumn(name = "payroll", nullable = false)
    private Payroll payrollBean;

    public PayrollData() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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