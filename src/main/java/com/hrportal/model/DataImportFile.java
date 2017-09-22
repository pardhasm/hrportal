package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the DataImportFiles database table.
 * 
 */
@Entity
@Table(name="DataImportFiles")
//@NamedQuery(name="DataImportFileRepository.findAll", query="SELECT d FROM DataImportFileRepository d")
public class DataImportFile extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(name="data_import_definition", nullable=false, length=200)
	private String dataImportDefinition;

	@Lob
	private String details;

	@Column(length=100)
	private String file;

	@Column(nullable=false, length=60)
    @NotNull
    private String name;

	@Column(length=15)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	public DataImportFile() {
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


    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

}