package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Payroll database table.
 */
@Entity
@Table(name = "Payroll")
//@NamedQuery(name="Payroll.findAll", query="SELECT p FROM Payroll p")
public class Payroll implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "column_template")
    private BigInteger columnTemplate;

    @Column(length = 500)
    private String columns;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_end")
    private Date dateEnd;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_start")
    private Date dateStart;

    @Column(nullable = false)
    private BigInteger department;

    @Column(length = 200)
    private String name;

    @Column(name = "pay_period", nullable = false)
    private BigInteger payPeriod;

    private BigInteger payslipTemplate;

    @Column(length = 20)
    private String status;

    //bi-directional many-to-one association to PayrollData
    @OneToMany(mappedBy = "payrollBean", fetch = FetchType.EAGER)
    private Set<PayrollData> payrollData;

    public Payroll() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getColumnTemplate() {
        return this.columnTemplate;
    }

    public void setColumnTemplate(BigInteger columnTemplate) {
        this.columnTemplate = columnTemplate;
    }

    public String getColumns() {
        return this.columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public Date getDateEnd() {
        return this.dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return this.dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public BigInteger getDepartment() {
        return this.department;
    }

    public void setDepartment(BigInteger department) {
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPayPeriod() {
        return this.payPeriod;
    }

    public void setPayPeriod(BigInteger payPeriod) {
        this.payPeriod = payPeriod;
    }

    public BigInteger getPayslipTemplate() {
        return this.payslipTemplate;
    }

    public void setPayslipTemplate(BigInteger payslipTemplate) {
        this.payslipTemplate = payslipTemplate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<PayrollData> getPayrollData() {
        return this.payrollData;
    }

    public void setPayrollData(Set<PayrollData> payrollData) {
        this.payrollData = payrollData;
    }

    public PayrollData addPayrollData(PayrollData payrollData) {
        getPayrollData().add(payrollData);
        payrollData.setPayrollBean(this);

        return payrollData;
    }

    public PayrollData removePayrollData(PayrollData payrollData) {
        getPayrollData().remove(payrollData);
        payrollData.setPayrollBean(null);

        return payrollData;
    }

}