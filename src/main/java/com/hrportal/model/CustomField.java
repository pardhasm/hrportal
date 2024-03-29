package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the CustomFields database table.
 * 
 */
@Entity
@Table(name="CustomFields")
//@NamedQuery(name="CustomField.findAll", query="SELECT c FROM CustomField c")
public class CustomField extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Lob
	private String data;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Display display;

	@Column(name="display_order")
	private int displayOrder;

	@Column(name="display_section", length=50)
	private String displaySection;

	@Column(name="field_label", length=50)
	private String fieldLabel;

	@Column(name="field_options", length=500)
	private String fieldOptions;

	@Column(name="field_type", length=20)
	private String fieldType;

	@Column(name="field_validation", length=50)
	private String fieldValidation;

	@Column(nullable=false, length=20)
    @NotNull
    private String name;

	@Column(nullable=false, length=20)
    @NotNull
    private String type;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	public CustomField() {
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

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Display getDisplay() {
		return this.display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public int getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getDisplaySection() {
		return this.displaySection;
	}

	public void setDisplaySection(String displaySection) {
		this.displaySection = displaySection;
	}

	public String getFieldLabel() {
		return this.fieldLabel;
	}

	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}

	public String getFieldOptions() {
		return this.fieldOptions;
	}

	public void setFieldOptions(String fieldOptions) {
		this.fieldOptions = fieldOptions;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldValidation() {
		return this.fieldValidation;
	}

	public void setFieldValidation(String fieldValidation) {
		this.fieldValidation = fieldValidation;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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