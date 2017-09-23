package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;



/**
 * The persistent class for the EmployeeApprovals database table.
 * 
 */
@Entity
@Table(name="EmployeeApprovals")
//@NamedQuery(name="EmployeeApproval.findAll", query="SELECT e FROM EmployeeApproval e")
public class EmployeeApproval extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private int active;

    private Long approver;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(nullable=false)
    private Long element;

	private int level;

	private int status;

	@Column(nullable=false, length=100)
	private String type;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

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

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
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