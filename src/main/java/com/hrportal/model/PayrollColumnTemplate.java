package com.hrportal.model;

import javax.persistence.*;


/**
 * The persistent class for the PayrollColumnTemplateRepository database table.
 * 
 */
@Entity
@Table(name = "PayrollColumnTemplateRepository")
//@NamedQuery(name="PayrollColumnTemplate.findAll", query="SELECT p FROM PayrollColumnTemplate p")
public class PayrollColumnTemplate extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=500)
	private String columns;

	@Column(length=50)
	private String name;

	public PayrollColumnTemplate() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColumns() {
		return this.columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}