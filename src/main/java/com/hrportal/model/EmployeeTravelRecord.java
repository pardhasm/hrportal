package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * The persistent class for the EmployeeTravelRecords database table.
 * 
 */
@Entity
@Table(name="EmployeeTravelRecords")
//@NamedQuery(name="EmployeeTravelRecord.findAll", query="SELECT e FROM EmployeeTravelRecord e")
public class EmployeeTravelRecord extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String attachment1;

	@Column(length=100)
	private String attachment2;

	@Column(length=100)
	private String attachment3;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

    private Long currency;

	@Column(length=500)
	private String details;

	@Column(precision=10, scale=3)
	private BigDecimal funding;

	@Column(nullable=false, length=200)
	private String purpose;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="return_date")
	private Date returnDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="travel_date")
	private Date travelDate;

	@Column(name="travel_from", nullable=false, length=200)
	private String travelFrom;

	@Column(name="travel_to", nullable=false, length=200)
	private String travelTo;

	@Column(length=20)
	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public EmployeeTravelRecord() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public BigDecimal getFunding() {
		return this.funding;
	}

	public void setFunding(BigDecimal funding) {
		this.funding = funding;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}



	public Date getTravelDate() {
		return this.travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getTravelFrom() {
		return this.travelFrom;
	}

	public void setTravelFrom(String travelFrom) {
		this.travelFrom = travelFrom;
	}

	public String getTravelTo() {
		return this.travelTo;
	}

	public void setTravelTo(String travelTo) {
		this.travelTo = travelTo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

}