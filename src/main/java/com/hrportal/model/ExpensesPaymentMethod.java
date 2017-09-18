package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ExpensesPaymentMethods database table.
 * 
 */
@Entity
@Table(name="ExpensesPaymentMethods")
//@NamedQuery(name="ExpensesPaymentMethod.findAll", query="SELECT e FROM ExpensesPaymentMethod e")
public class ExpensesPaymentMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(nullable=false, length=500)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to EmployeeExpens
	@OneToMany(mappedBy="expensesPaymentMethod", fetch=FetchType.EAGER)
	private Set<EmployeeExpens> employeeExpenses;

	public ExpensesPaymentMethod() {
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

	public Set<EmployeeExpens> getEmployeeExpenses() {
		return this.employeeExpenses;
	}

	public void setEmployeeExpenses(Set<EmployeeExpens> employeeExpenses) {
		this.employeeExpenses = employeeExpenses;
	}

	public EmployeeExpens addEmployeeExpens(EmployeeExpens employeeExpens) {
		getEmployeeExpenses().add(employeeExpens);
		employeeExpens.setExpensesPaymentMethod(this);

		return employeeExpens;
	}

	public EmployeeExpens removeEmployeeExpens(EmployeeExpens employeeExpens) {
		getEmployeeExpenses().remove(employeeExpens);
		employeeExpens.setExpensesPaymentMethod(null);

		return employeeExpens;
	}

}