package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the EmployeeDocuments database table.
 * 
 */
@Entity
@Table(name="EmployeeDocuments")
//@NamedQuery(name="EmployeeDocument.findAll", query="SELECT e FROM EmployeeDocument e")
public class EmployeeDocument extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String attachment;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_added", nullable=false)
    private DateTime dateAdded;

	@Lob
	private String details;

	@Column(name="expire_notification_last")
	private int expireNotificationLast;

	@Lob
	private String signature;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="valid_until", nullable=false)
    private DateTime validUntil;

	//bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name="document")
	private Document documentBean;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public EmployeeDocument() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

    public DateTime getDateAdded() {
        return this.dateAdded;
	}

    public void setDateAdded(DateTime dateAdded) {
        this.dateAdded = dateAdded;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getExpireNotificationLast() {
		return this.expireNotificationLast;
	}

	public void setExpireNotificationLast(int expireNotificationLast) {
		this.expireNotificationLast = expireNotificationLast;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}


    public DateTime getValidUntil() {
        return this.validUntil;
	}

    public void setValidUntil(DateTime validUntil) {
        this.validUntil = validUntil;
	}

	public Document getDocumentBean() {
		return this.documentBean;
	}

	public void setDocumentBean(Document documentBean) {
		this.documentBean = documentBean;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}