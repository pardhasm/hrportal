package com.hrportal.model;

import javax.persistence.*;


/**
 * The persistent class for the EmployeeLanguages database table.
 * 
 */
@Entity
@Table(name="EmployeeLanguages")

public class EmployeeLanguage extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	@Enumerated(EnumType.STRING)
	private Proficiency reading;

	@Column(length=100)
	@Enumerated(EnumType.STRING)
	private Proficiency speaking;

	@Column(length=100)
	@Enumerated(EnumType.STRING)
	private Proficiency understanding;

	@Column(length=100)
	@Enumerated(EnumType.STRING)
	private Proficiency writing;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proficiency getReading() {
		return reading;
	}

	public void setReading(Proficiency reading) {
		this.reading = reading;
	}

	public Proficiency getSpeaking() {
		return speaking;
	}

	public void setSpeaking(Proficiency speaking) {
		this.speaking = speaking;
	}

	public Proficiency getUnderstanding() {
		return understanding;
	}

	public void setUnderstanding(Proficiency understanding) {
		this.understanding = understanding;
	}

	public Proficiency getWriting() {
		return this.writing;
	}

	public void setWriting(Proficiency writing) {
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