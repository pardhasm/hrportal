package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the FieldNameMappings database table.
 * 
 */
@Entity
@Table(name="FieldNameMappings")
//@NamedQuery(name="FieldNameMapping.findAll", query="SELECT f FROM FieldNameMapping f")
public class FieldNameMapping extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

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

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	public FieldNameMapping() {
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

    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

}