package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EmployeeSkills database table.
 * 
 */
@Entity
@Table(name="EmployeeSkills")
//@NamedQuery(name="EmployeeSkill.findAll", query="SELECT e FROM EmployeeSkill e")
public class EmployeeSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=400)
	private String details;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Skill skill;

	public EmployeeSkill() {
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

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}