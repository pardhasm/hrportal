package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the ExpensesCategories database table.
 * 
 */
@Entity
@Table(name="ExpensesCategories")
//@NamedQuery(name="ExpensesCategory.findAll", query="SELECT e FROM ExpensesCategory e")
public class ExpensesCategory extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(nullable=false, length=500)
	private String name;

	@Column(name="pre_approve", length=20)
	@Enumerated(EnumType.STRING)
	private Polar preApprove;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	//bi-directional many-to-one association to EmployeeExpens
	@OneToMany(mappedBy="expensesCategory", fetch=FetchType.EAGER)
	private Set<EmployeeExpense> employeeExpenses;

	public ExpensesCategory() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Polar getPreApprove() {
		return this.preApprove;
	}

	public void setPreApprove(Polar preApprove) {
		this.preApprove = preApprove;
	}

    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

	public Set<EmployeeExpense> getEmployeeExpenses() {
		return this.employeeExpenses;
	}

	public void setEmployeeExpenses(Set<EmployeeExpense> employeeExpenses) {
		this.employeeExpenses = employeeExpenses;
	}

	public EmployeeExpense addEmployeeExpens(EmployeeExpense employeeExpense) {
		getEmployeeExpenses().add(employeeExpense);
		employeeExpense.setExpensesCategory(this);

		return employeeExpense;
	}

	public EmployeeExpense removeEmployeeExpens(EmployeeExpense employeeExpense) {
		getEmployeeExpenses().remove(employeeExpense);
		employeeExpense.setExpensesCategory(null);

		return employeeExpense;
	}

}