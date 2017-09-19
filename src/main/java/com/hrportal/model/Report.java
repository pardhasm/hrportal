package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Reports database table.
 * 
 */
@Entity
@Table(name="Reports")
//@NamedQuery(name="Report.findAll", query="SELECT r FROM Report r")
public class Report extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, length=15)
	private String output;

	@Lob
	private String parameters;

	@Column(nullable=false, length=500)
	private String paramOrder;

	@Lob
	private String query;

	@Column(name="report_group", length=500)
	private String reportGroup;

	@Column(length=20)
	private String type;

	public Report() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getParameters() {
		return this.parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getParamOrder() {
		return this.paramOrder;
	}

	public void setParamOrder(String paramOrder) {
		this.paramOrder = paramOrder;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getReportGroup() {
		return this.reportGroup;
	}

	public void setReportGroup(String reportGroup) {
		this.reportGroup = reportGroup;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}