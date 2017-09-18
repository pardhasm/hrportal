package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * The persistent class for the EmployeeApprovals database table.
 * 
 */
@Entity
@Table(name="EmployeeApprovals")
//@NamedQuery(name="EmployeeApproval.findAll", query="SELECT e FROM EmployeeApproval e")
public class EmployeeApproval implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private int active;

    private Long approver;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(nullable=false)
    private Long element;

	private int level;

	private int status;

	@Column(nullable=false, length=100)
	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	public EmployeeApproval() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

    public Long getApprover() {
        return this.approver;
	}

    public void setApprover(Long approver) {
        this.approver = approver;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

    public Long getElement() {
        return this.element;
	}

    public void setElement(Long element) {
        this.element = element;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
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