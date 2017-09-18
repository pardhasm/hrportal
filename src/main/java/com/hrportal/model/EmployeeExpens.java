package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * The persistent class for the EmployeeExpenses database table.
 * 
 */
@Entity
@Table(name="EmployeeExpenses")
//@NamedQuery(name="EmployeeExpens.findAll", query="SELECT e FROM EmployeeExpens e")
public class EmployeeExpens implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(precision=10, scale=3)
	private BigDecimal amount;

	@Column(length=100)
	private String attachment1;

	@Column(length=100)
	private String attachment2;

	@Column(length=100)
	private String attachment3;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

    private Long currency;

	@Temporal(TemporalType.DATE)
	@Column(name="expense_date")
	private Date expenseDate;

	@Lob
	private String notes;

	@Column(nullable=false, length=500)
	private String payee;

	@Column(length=20)
	private String status;

	@Column(name="transaction_no", nullable=false, length=300)
	private String transactionNo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	//bi-directional many-to-one association to ExpensesCategory
	@ManyToOne
	@JoinColumn(name="category", nullable=false)
	private ExpensesCategory expensesCategory;

	//bi-directional many-to-one association to ExpensesPaymentMethod
	@ManyToOne
	@JoinColumn(name="payment_method", nullable=false)
	private ExpensesPaymentMethod expensesPaymentMethod;

	public EmployeeExpens() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAttachment1() {
		return this.attachment1;
	}

	public void setAttachment1(String attachment1) {
		this.attachment1 = attachment1;
	}

	public String getAttachment2() {
		return this.attachment2;
	}

	public void setAttachment2(String attachment2) {
		this.attachment2 = attachment2;
	}

	public String getAttachment3() {
		return this.attachment3;
	}

	public void setAttachment3(String attachment3) {
		this.attachment3 = attachment3;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

    public Long getCurrency() {
        return this.currency;
	}

    public void setCurrency(Long currency) {
        this.currency = currency;
	}

	public Date getExpenseDate() {
		return this.expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPayee() {
		return this.payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionNo() {
		return this.transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public ExpensesCategory getExpensesCategory() {
		return this.expensesCategory;
	}

	public void setExpensesCategory(ExpensesCategory expensesCategory) {
		this.expensesCategory = expensesCategory;
	}

	public ExpensesPaymentMethod getExpensesPaymentMethod() {
		return this.expensesPaymentMethod;
	}

	public void setExpensesPaymentMethod(ExpensesPaymentMethod expensesPaymentMethod) {
		this.expensesPaymentMethod = expensesPaymentMethod;
	}

}