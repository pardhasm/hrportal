package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Documents database table.
 * 
 */
@Entity
@Table(name="Documents")
//@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Lob
	private String details;

	@Column(name="expire_notification", length=20)
	private String expireNotification;

	@Column(name="expire_notification_day", length=20)
	private String expireNotificationDay;

	@Column(name="expire_notification_month", length=20)
	private String expireNotificationMonth;

	@Column(name="expire_notification_week", length=20)
	private String expireNotificationWeek;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)
	private String sign;

	@Column(name="sign_label", length=500)
	private String signLabel;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to EmployeeDocument
	@OneToMany(mappedBy="documentBean", fetch=FetchType.EAGER)
	private Set<EmployeeDocument> employeeDocuments;

	public Document() {
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getExpireNotification() {
		return this.expireNotification;
	}

	public void setExpireNotification(String expireNotification) {
		this.expireNotification = expireNotification;
	}

	public String getExpireNotificationDay() {
		return this.expireNotificationDay;
	}

	public void setExpireNotificationDay(String expireNotificationDay) {
		this.expireNotificationDay = expireNotificationDay;
	}

	public String getExpireNotificationMonth() {
		return this.expireNotificationMonth;
	}

	public void setExpireNotificationMonth(String expireNotificationMonth) {
		this.expireNotificationMonth = expireNotificationMonth;
	}

	public String getExpireNotificationWeek() {
		return this.expireNotificationWeek;
	}

	public void setExpireNotificationWeek(String expireNotificationWeek) {
		this.expireNotificationWeek = expireNotificationWeek;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSignLabel() {
		return this.signLabel;
	}

	public void setSignLabel(String signLabel) {
		this.signLabel = signLabel;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<EmployeeDocument> getEmployeeDocuments() {
		return this.employeeDocuments;
	}

	public void setEmployeeDocuments(Set<EmployeeDocument> employeeDocuments) {
		this.employeeDocuments = employeeDocuments;
	}

	public EmployeeDocument addEmployeeDocument(EmployeeDocument employeeDocument) {
		getEmployeeDocuments().add(employeeDocument);
		employeeDocument.setDocumentBean(this);

		return employeeDocument;
	}

	public EmployeeDocument removeEmployeeDocument(EmployeeDocument employeeDocument) {
		getEmployeeDocuments().remove(employeeDocument);
		employeeDocument.setDocumentBean(null);

		return employeeDocument;
	}

}