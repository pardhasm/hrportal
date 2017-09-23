package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the CustomFieldValues database table.
 * 
 */
@Entity
@Table(name="CustomFieldValues")
//@NamedQuery(name="CustomFieldValue.findAll", query="SELECT c FROM CustomFieldValue c")
public class CustomFieldValue extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(nullable=false, length=60)
	private String name;

	@Column(name="object_id", nullable=false, length=60)
	private String objectId;

	@Column(nullable=false, length=20)
	private String type;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	@Lob
	private String value;

	public CustomFieldValue() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObjectId() {
		return this.objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}