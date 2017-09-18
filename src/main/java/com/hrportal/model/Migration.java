package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Migrations database table.
 * 
 */
@Entity
@Table(name="Migrations")
//@NamedQuery(name="Migration.findAll", query="SELECT m FROM Migration m")
public class Migration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(nullable=false, length=50)
	private String file;

	@Column(name="last_error", length=500)
	private String lastError;

	@Column(length=20)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Column(nullable=false)
	private int version;

	public Migration() {
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

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLastError() {
		return this.lastError;
	}

	public void setLastError(String lastError) {
		this.lastError = lastError;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}