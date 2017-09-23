package com.hrportal.model;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the CompanyLoans database table.
 * 
 */
@Entity
@Table(name="CompanyLoans")
//@NamedQuery(name="CompanyLoan.findAll", query="SELECT c FROM CompanyLoan c")
public class CompanyLoan extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to EmployeeCompanyLoan
	@OneToMany(mappedBy="companyLoan", fetch=FetchType.EAGER)
	private Set<EmployeeCompanyLoan> employeeCompanyLoans;

	public CompanyLoan() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeCompanyLoan> getEmployeeCompanyLoans() {
		return this.employeeCompanyLoans;
	}

	public void setEmployeeCompanyLoans(Set<EmployeeCompanyLoan> employeeCompanyLoans) {
		this.employeeCompanyLoans = employeeCompanyLoans;
	}

	public EmployeeCompanyLoan addEmployeeCompanyLoan(EmployeeCompanyLoan employeeCompanyLoan) {
		getEmployeeCompanyLoans().add(employeeCompanyLoan);
		employeeCompanyLoan.setCompanyLoan(this);

		return employeeCompanyLoan;
	}

	public EmployeeCompanyLoan removeEmployeeCompanyLoan(EmployeeCompanyLoan employeeCompanyLoan) {
		getEmployeeCompanyLoans().remove(employeeCompanyLoan);
		employeeCompanyLoan.setCompanyLoan(null);

		return employeeCompanyLoan;
	}

}