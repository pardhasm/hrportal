package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * The persistent class for the ReportFiles database table.
 * 
 */
@Entity
@Table(name="ReportFiles")
//@NamedQuery(name="ReportFile.findAll", query="SELECT r FROM ReportFile r")
public class ReportFile extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=100)
	private String attachment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

    private Long employee;

	@Column(nullable=false, length=100)
	private String name;

	public ReportFile() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

    public Long getEmployee() {
        return this.employee;
	}

    public void setEmployee(Long employee) {
        this.employee = employee;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}