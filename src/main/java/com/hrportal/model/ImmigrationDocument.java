package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ImmigrationDocuments database table.
 * 
 */
@Entity
@Table(name="ImmigrationDocuments")
//@NamedQuery(name="ImmigrationDocument.findAll", query="SELECT i FROM ImmigrationDocument i")
public class ImmigrationDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="alert_before_day_number", nullable=false)
	private int alertBeforeDayNumber;

	@Column(name="alert_before_expiry", length=20)
	private String alertBeforeExpiry;

	@Column(name="alert_on_missing", length=20)
	private String alertOnMissing;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)
	private String required;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to EmployeeImmigration
	@OneToMany(mappedBy="immigrationDocument", fetch=FetchType.EAGER)
	private Set<EmployeeImmigration> employeeImmigrations;

	public ImmigrationDocument() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAlertBeforeDayNumber() {
		return this.alertBeforeDayNumber;
	}

	public void setAlertBeforeDayNumber(int alertBeforeDayNumber) {
		this.alertBeforeDayNumber = alertBeforeDayNumber;
	}

	public String getAlertBeforeExpiry() {
		return this.alertBeforeExpiry;
	}

	public void setAlertBeforeExpiry(String alertBeforeExpiry) {
		this.alertBeforeExpiry = alertBeforeExpiry;
	}

	public String getAlertOnMissing() {
		return this.alertOnMissing;
	}

	public void setAlertOnMissing(String alertOnMissing) {
		this.alertOnMissing = alertOnMissing;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	public String getRequired() {
		return this.required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<EmployeeImmigration> getEmployeeImmigrations() {
		return this.employeeImmigrations;
	}

	public void setEmployeeImmigrations(Set<EmployeeImmigration> employeeImmigrations) {
		this.employeeImmigrations = employeeImmigrations;
	}

	public EmployeeImmigration addEmployeeImmigration(EmployeeImmigration employeeImmigration) {
		getEmployeeImmigrations().add(employeeImmigration);
		employeeImmigration.setImmigrationDocument(this);

		return employeeImmigration;
	}

	public EmployeeImmigration removeEmployeeImmigration(EmployeeImmigration employeeImmigration) {
		getEmployeeImmigrations().remove(employeeImmigration);
		employeeImmigration.setImmigrationDocument(null);

		return employeeImmigration;
	}

}