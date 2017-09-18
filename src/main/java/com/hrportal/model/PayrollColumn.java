package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the PayrollColumns database table.
 * 
 */
@Entity
@Table(name="PayrollColumns")
//@NamedQuery(name="PayrollColumn.findAll", query="SELECT p FROM PayrollColumn p")
public class PayrollColumn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="add_columns", length=500)
	private String addColumns;

	@Column(name="calculation_columns", length=500)
	private String calculationColumns;

	@Column(name="calculation_function", length=100)
	private String calculationFunction;

	@Column(name="calculation_hook", length=200)
	private String calculationHook;

	private int colorder;

	@Column(length=500)
	private String deductions;

	@Column(name="default_value", length=25)
	private String defaultValue;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Polar editable;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Polar enabled;

	@Column(length=50)
	private String name;

	@Column(name="salary_components", length=500)
	private String salaryComponents;

	@Column(name="sub_columns", length=500)
	private String subColumns;

	public PayrollColumn() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddColumns() {
		return this.addColumns;
	}

	public void setAddColumns(String addColumns) {
		this.addColumns = addColumns;
	}

	public String getCalculationColumns() {
		return this.calculationColumns;
	}

	public void setCalculationColumns(String calculationColumns) {
		this.calculationColumns = calculationColumns;
	}

	public String getCalculationFunction() {
		return this.calculationFunction;
	}

	public void setCalculationFunction(String calculationFunction) {
		this.calculationFunction = calculationFunction;
	}

	public String getCalculationHook() {
		return this.calculationHook;
	}

	public void setCalculationHook(String calculationHook) {
		this.calculationHook = calculationHook;
	}

	public int getColorder() {
		return this.colorder;
	}

	public void setColorder(int colorder) {
		this.colorder = colorder;
	}

	public String getDeductions() {
		return this.deductions;
	}

	public void setDeductions(String deductions) {
		this.deductions = deductions;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Polar getEditable() {
		return this.editable;
	}

	public void setEditable(Polar editable) {
		this.editable = editable;
	}

	public Polar getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Polar enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalaryComponents() {
		return this.salaryComponents;
	}

	public void setSalaryComponents(String salaryComponents) {
		this.salaryComponents = salaryComponents;
	}

	public String getSubColumns() {
		return this.subColumns;
	}

	public void setSubColumns(String subColumns) {
		this.subColumns = subColumns;
	}

}