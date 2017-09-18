package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EmployeeLanguages database table.
 * 
 */
@Entity
@Table(name="EmployeeLanguages")
//@NamedQuery(name="EmployeeLanguage.findAll", query="SELECT e FROM EmployeeLanguage e")
public class EmployeeLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String reading;

	@Column(length=100)
	private String speaking;

	@Column(length=100)
	private String understanding;

	@Column(length=100)
	private String writing;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;

	public EmployeeLanguage() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReading() {
		return this.reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public String getSpeaking() {
		return this.speaking;
	}

	public void setSpeaking(String speaking) {
		this.speaking = speaking;
	}

	public String getUnderstanding() {
		return this.understanding;
	}

	public void setUnderstanding(String understanding) {
		this.understanding = understanding;
	}

	public String getWriting() {
		return this.writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}