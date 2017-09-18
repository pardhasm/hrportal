package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Forms database table.
 * 
 */
@Entity
@Table(name="Forms")
//@NamedQuery(name="Form.findAll", query="SELECT f FROM Form f")
public class Form implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=500)
	private String description;

	@Lob
	private String items;

	@Column(nullable=false, length=50)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to EmployeeForm
	@OneToMany(mappedBy="formBean", fetch=FetchType.EAGER)
	private Set<EmployeeForm> employeeForms;

	public Form() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItems() {
		return this.items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<EmployeeForm> getEmployeeForms() {
		return this.employeeForms;
	}

	public void setEmployeeForms(Set<EmployeeForm> employeeForms) {
		this.employeeForms = employeeForms;
	}

	public EmployeeForm addEmployeeForm(EmployeeForm employeeForm) {
		getEmployeeForms().add(employeeForm);
		employeeForm.setFormBean(this);

		return employeeForm;
	}

	public EmployeeForm removeEmployeeForm(EmployeeForm employeeForm) {
		getEmployeeForms().remove(employeeForm);
		employeeForm.setFormBean(null);

		return employeeForm;
	}

}