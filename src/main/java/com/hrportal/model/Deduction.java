package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Deductions database table.
 * 
 */
@Entity
@Table(name="Deductions")
//@NamedQuery(name="Deduction.findAll", query="SELECT d FROM Deduction d")
public class Deduction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=250)
	private String component;

	@Column(length=250)
	private String componentType;

	@Column(nullable=false, length=100)
	private String name;

	private int payrollColumn;

	@Lob
	private String rangeAmounts;

	//bi-directional many-to-one association to DeductionGroup
	@ManyToOne
	@JoinColumn(name="deduction_group")
	private DeductionGroup deductionGroupBean;

	public Deduction() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComponent() {
		return this.component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getComponentType() {
		return this.componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPayrollColumn() {
		return this.payrollColumn;
	}

	public void setPayrollColumn(int payrollColumn) {
		this.payrollColumn = payrollColumn;
	}

	public String getRangeAmounts() {
		return this.rangeAmounts;
	}

	public void setRangeAmounts(String rangeAmounts) {
		this.rangeAmounts = rangeAmounts;
	}

	public DeductionGroup getDeductionGroupBean() {
		return this.deductionGroupBean;
	}

	public void setDeductionGroupBean(DeductionGroup deductionGroupBean) {
		this.deductionGroupBean = deductionGroupBean;
	}

}