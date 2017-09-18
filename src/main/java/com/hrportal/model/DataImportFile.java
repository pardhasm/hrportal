package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the DataImportFiles database table.
 * 
 */
@Entity
@Table(name="DataImportFiles")
//@NamedQuery(name="DataImportFile.findAll", query="SELECT d FROM DataImportFile d")
public class DataImportFile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="data_import_definition", nullable=false, length=200)
	private String dataImportDefinition;

	@Lob
	private String details;

	@Column(length=100)
	private String file;

	@Column(nullable=false, length=60)
	private String name;

	@Column(length=15)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	public DataImportFile() {
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

	public String getDataImportDefinition() {
		return this.dataImportDefinition;
	}

	public void setDataImportDefinition(String dataImportDefinition) {
		this.dataImportDefinition = dataImportDefinition;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

}