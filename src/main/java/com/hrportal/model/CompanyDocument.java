package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the CompanyDocuments database table.
 * 
 */
@Entity
@Table(name="CompanyDocuments")
//@NamedQuery(name="CompanyDocument.findAll", query="SELECT c FROM CompanyDocument c")
public class CompanyDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String attachment;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	@Column(name="notify_employees", length=20)
	@Enumerated(EnumType.STRING)
	private Polar notifyEmployees;

	@Column(name="share_departments", length=100)
	private String shareDepartments;

	@Column(name="share_employees", length=100)
	private String shareEmployees;

	@Column(name="share_userlevel", length=100)
	private String shareUserlevel;

	@Column(length=20)
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name="valid_until")
	private Date validUntil;

	public CompanyDocument() {
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

	public Polar getNotifyEmployees() {
		return this.notifyEmployees;
	}

	public void setNotifyEmployees(Polar notifyEmployees) {
		this.notifyEmployees = notifyEmployees;
	}

	public String getShareDepartments() {
		return this.shareDepartments;
	}

	public void setShareDepartments(String shareDepartments) {
		this.shareDepartments = shareDepartments;
	}

	public String getShareEmployees() {
		return this.shareEmployees;
	}

	public void setShareEmployees(String shareEmployees) {
		this.shareEmployees = shareEmployees;
	}

	public String getShareUserlevel() {
		return this.shareUserlevel;
	}

	public void setShareUserlevel(String shareUserlevel) {
		this.shareUserlevel = shareUserlevel;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

}