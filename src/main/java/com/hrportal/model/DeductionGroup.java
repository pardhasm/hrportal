package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the DeductionGroup database table.
 */
@Entity
@Table(name = "DeductionGroup")
//@NamedQuery(name="DeductionGroup.findAll", query="SELECT d FROM DeductionGroup d")
public class DeductionGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false, length = 100)
    private String name;

    //bi-directional many-to-one association to Deduction
    @OneToMany(mappedBy = "deductionGroupBean", fetch = FetchType.EAGER)
    private Set<Deduction> deductions;

    //bi-directional many-to-one association to PayrollEmployee
    @OneToMany(mappedBy = "deductionGroupBean", fetch = FetchType.EAGER)
    private Set<PayrollEmployee> payrollEmployees;

    public DeductionGroup() {
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

    public Set<Deduction> getDeductions() {
        return this.deductions;
    }

    public void setDeductions(Set<Deduction> deductions) {
        this.deductions = deductions;
    }

    public Deduction addDeduction(Deduction deduction) {
        getDeductions().add(deduction);
        deduction.setDeductionGroupBean(this);

        return deduction;
    }

    public Deduction removeDeduction(Deduction deduction) {
        getDeductions().remove(deduction);
        deduction.setDeductionGroupBean(null);

        return deduction;
    }

    public Set<PayrollEmployee> getPayrollEmployees() {
        return this.payrollEmployees;
    }

    public void setPayrollEmployees(Set<PayrollEmployee> payrollEmployees) {
        this.payrollEmployees = payrollEmployees;
    }

    public PayrollEmployee addPayrollEmployee(PayrollEmployee payrollEmployee) {
        getPayrollEmployees().add(payrollEmployee);
        payrollEmployee.setDeductionGroupBean(this);

        return payrollEmployee;
    }

    public PayrollEmployee removePayrollEmployee(PayrollEmployee payrollEmployee) {
        getPayrollEmployees().remove(payrollEmployee);
        payrollEmployee.setDeductionGroupBean(null);

        return payrollEmployee;
    }

}