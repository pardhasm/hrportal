package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the PayslipTemplates database table.
 * 
 */
@Entity
@Table(name="PayslipTemplates")
//@NamedQuery(name="PayslipTemplate.findAll", query="SELECT p FROM PayslipTemplate p")
public class PayslipTemplate extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Lob
	private String data;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	public PayslipTemplate() {
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