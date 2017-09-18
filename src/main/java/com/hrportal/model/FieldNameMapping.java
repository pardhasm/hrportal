package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the FieldNameMappings database table.
 * 
 */
@Entity
@Table(name="FieldNameMappings")
//@NamedQuery(name="FieldNameMapping.findAll", query="SELECT f FROM FieldNameMapping f")
public class FieldNameMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Display display;

	@Column(nullable=false, length=20)
	private String name;

	@Column(length=200)
	private String textMapped;

	@Column(length=200)
	private String textOrig;

	@Column(nullable=false, length=20)
	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	public FieldNameMapping() {
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

	public Display getDisplay() {
		return this.display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTextMapped() {
		return this.textMapped;
	}

	public void setTextMapped(String textMapped) {
		this.textMapped = textMapped;
	}

	public String getTextOrig() {
		return this.textOrig;
	}

	public void setTextOrig(String textOrig) {
		this.textOrig = textOrig;
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

}