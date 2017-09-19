package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Emails database table.
 * 
 */
@Entity
@Table(name="Emails")
//@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=500)
	private String bcclist;

	@Column(length=500)
	private String cclist;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=500)
	private String error;

	@Lob
	private String params;


	@Column(nullable=false, length=300)
	private String subject;

	@Lob
	private String template;

	@Column(nullable=false, length=300)
	private String toEmail;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	public Email() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBcclist() {
		return this.bcclist;
	}

	public void setBcclist(String bcclist) {
		this.bcclist = bcclist;
	}

	public String getCclist() {
		return this.cclist;
	}

	public void setCclist(String cclist) {
		this.cclist = cclist;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}



	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getToEmail() {
		return this.toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}