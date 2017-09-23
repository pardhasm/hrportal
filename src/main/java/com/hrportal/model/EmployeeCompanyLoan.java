package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;



/**
 * The persistent class for the EmployeeCompanyLoans database table.
 * 
 */
@Entity
@Table(name="EmployeeCompanyLoans")
//@NamedQuery(name="EmployeeCompanyLoan.findAll", query="SELECT e FROM EmployeeCompanyLoan e")
public class EmployeeCompanyLoan extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal amount;

    private Long currency;

	@Lob
	private String details;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="last_installment_date", nullable=false)
    private DateTime lastInstallmentDate;

	@Column(name="monthly_installment", nullable=false, precision=10, scale=2)
	private BigDecimal monthlyInstallment;

	@Column(name="period_months")
    private Long periodMonths;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="start_date", nullable=false)
    private DateTime startDate;


	//bi-directional many-to-one association to CompanyLoan
	@ManyToOne
	@JoinColumn(name="loan")
	private CompanyLoan companyLoan;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public EmployeeCompanyLoan() {
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

    public Long getCurrency() {
        return this.currency;
	}

    public void setCurrency(Long currency) {
        this.currency = currency;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

    public DateTime getLastInstallmentDate() {
        return this.lastInstallmentDate;
	}

    public void setLastInstallmentDate(DateTime lastInstallmentDate) {
        this.lastInstallmentDate = lastInstallmentDate;
	}

	public BigDecimal getMonthlyInstallment() {
		return this.monthlyInstallment;
	}

	public void setMonthlyInstallment(BigDecimal monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

    public Long getPeriodMonths() {
        return this.periodMonths;
	}

    public void setPeriodMonths(Long periodMonths) {
        this.periodMonths = periodMonths;
	}

    public DateTime getStartDate() {
        return this.startDate;
	}

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
	}



	public CompanyLoan getCompanyLoan() {
		return this.companyLoan;
	}

	public void setCompanyLoan(CompanyLoan companyLoan) {
		this.companyLoan = companyLoan;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}