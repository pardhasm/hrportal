package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the Forms database table.
 * 
 */
@Entity
@Table(name="Forms")
//@NamedQuery(name="Form.findAll", query="SELECT f FROM Form f")
public class Form extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(length=500)
	private String description;

	@Lob
	private String items;

	@Column(nullable=false, length=50)
    @NotNull
    private String name;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

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

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
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

    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
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