package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the StatusChangeLogs database table.
 * 
 */
@Entity
@Table(name="StatusChangeLogs")
//@NamedQuery(name="StatusChangeLog.findAll", query="SELECT s FROM StatusChangeLog s")
public class StatusChangeLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(nullable=false, length=500)
	private String data;

	@Column(nullable=false)
	private BigInteger element;

	@Column(name="status_from", length=20)
	private String statusFrom;

	@Column(name="status_to", length=20)
	private String statusTo;

	@Column(nullable=false, length=100)
	private String type;

	@Column(name="user_id")
	private BigInteger userId;

	public StatusChangeLog() {
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

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigInteger getElement() {
		return this.element;
	}

	public void setElement(BigInteger element) {
		this.element = element;
	}

	public String getStatusFrom() {
		return this.statusFrom;
	}

	public void setStatusFrom(String statusFrom) {
		this.statusFrom = statusFrom;
	}

	public String getStatusTo() {
		return this.statusTo;
	}

	public void setStatusTo(String statusTo) {
		this.statusTo = statusTo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

}