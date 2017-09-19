package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;



/**
 * The persistent class for the PayrollEmployees database table.
 * 
 */
@Entity
@Table(name="PayrollEmployees")
//@NamedQuery(name="PayrollEmployee.findAll", query="SELECT p FROM PayrollEmployee p")
public class PayrollEmployee extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    private Long currency;

	@Column(name="deduction_allowed", length=250)
	private String deductionAllowed;

	@Column(name="deduction_exemptions", length=250)
	private String deductionExemptions;

	@Column(name="pay_frequency")
	private int payFrequency;

	//bi-directional many-to-one association to DeductionGroup
	@ManyToOne
	@JoinColumn(name="deduction_group")
	private DeductionGroup deductionGroupBean;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public PayrollEmployee() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Long getCurrency() {
        return this.currency;
	}

    public void setCurrency(Long currency) {
        this.currency = currency;
	}

	public String getDeductionAllowed() {
		return this.deductionAllowed;
	}

	public void setDeductionAllowed(String deductionAllowed) {
		this.deductionAllowed = deductionAllowed;
	}

	public String getDeductionExemptions() {
		return this.deductionExemptions;
	}

	public void setDeductionExemptions(String deductionExemptions) {
		this.deductionExemptions = deductionExemptions;
	}

	public int getPayFrequency() {
		return this.payFrequency;
	}

	public void setPayFrequency(int payFrequency) {
		this.payFrequency = payFrequency;
	}

	public DeductionGroup getDeductionGroupBean() {
		return this.deductionGroupBean;
	}

	public void setDeductionGroupBean(DeductionGroup deductionGroupBean) {
		this.deductionGroupBean = deductionGroupBean;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}