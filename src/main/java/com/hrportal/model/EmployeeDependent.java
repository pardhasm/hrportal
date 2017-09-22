package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeDependents database table.
 * 
 */
@Entity
@Table(name="EmployeeDependents")
//@NamedQuery(name="EmployeeDependent.findAll", query="SELECT e FROM EmployeeDependent e")
public class EmployeeDependent extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime dob;

	@Column(name="id_number", length=25)
	private String idNumber;

	@Column(nullable=false, length=100)
    @NotNull
    private String name;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Relationship relationship;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
    @NotNull
    private Employee employeeBean;

	public EmployeeDependent() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public DateTime getDob() {
        return this.dob;
	}

    public void setDob(DateTime dob) {
        this.dob = dob;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Relationship getRelationship() {
		return this.relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}