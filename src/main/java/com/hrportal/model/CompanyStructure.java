package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the CompanyStructures database table.
 *
 */
@Entity
@Table(name = "CompanyStructures")
//@NamedQuery(name="CompanyStructure.findAll", query="SELECT c FROM CompanyStructure c")
public class CompanyStructure extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Lob
	private String address;

	@Column(nullable = false, length = 2)
	private String country;

	@Lob
	@Column(nullable = false)
	private String description;

	@Column(length = 255)
	private String heads;

	@Column(nullable = false, length = 100)
	private String timezone;

	@Lob
	@Column(nullable = false)
	private String title;

	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private Type type;

	//bi-directional many-to-one association to CompanyStructure
	@ManyToOne
	@JoinColumn(name = "parent")
	private CompanyStructure companyStructure;

	//bi-directional many-to-one association to CompanyStructure
	@OneToMany(mappedBy = "companyStructure", fetch = FetchType.EAGER)
	private Set<CompanyStructure> companyStructures;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy = "companyStructure", fetch = FetchType.EAGER)
	private Set<Employee> employees;

	public CompanyStructure() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHeads() {
		return this.heads;
	}

	public void setHeads(String heads) {
		this.heads = heads;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public CompanyStructure getCompanyStructure() {
		return this.companyStructure;
	}

	public void setCompanyStructure(CompanyStructure companyStructure) {
		this.companyStructure = companyStructure;
	}

	public Set<CompanyStructure> getCompanyStructures() {
		return this.companyStructures;
	}

	public void setCompanyStructures(Set<CompanyStructure> companyStructures) {
		this.companyStructures = companyStructures;
	}

	public CompanyStructure addCompanyStructure(CompanyStructure companyStructure) {
		getCompanyStructures().add(companyStructure);
		companyStructure.setCompanyStructure(this);

		return companyStructure;
	}

	public CompanyStructure removeCompanyStructure(CompanyStructure companyStructure) {
		getCompanyStructures().remove(companyStructure);
		companyStructure.setCompanyStructure(null);

		return companyStructure;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setCompanyStructure(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setCompanyStructure(null);

		return employee;
	}

}