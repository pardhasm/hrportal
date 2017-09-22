package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeForms database table.
 * 
 */
@Entity
@Table(name="EmployeeForms")
//@NamedQuery(name="EmployeeForm.findAll", query="SELECT e FROM EmployeeForm e")
public class EmployeeForm extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(length=20)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
    @NotNull
    private Employee employeeBean;

	//bi-directional many-to-one association to Form
	@ManyToOne
	@JoinColumn(name="form", nullable=false)
    @NotNull
    private Form formBean;

	public EmployeeForm() {
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


    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public Form getFormBean() {
		return this.formBean;
	}

	public void setFormBean(Form formBean) {
		this.formBean = formBean;
	}

}