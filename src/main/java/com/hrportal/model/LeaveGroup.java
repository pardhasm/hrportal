package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the LeaveGroups database table.
 * 
 */
@Entity
@Table(name="LeaveGroups")
//@NamedQuery(name="LeaveGroup.findAll", query="SELECT l FROM LeaveGroup l")
public class LeaveGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to LeaveGroupEmployee
	@OneToMany(mappedBy="leaveGroupBean", fetch=FetchType.EAGER)
	private Set<LeaveGroupEmployee> leaveGroupEmployees;

	public LeaveGroup() {
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<LeaveGroupEmployee> getLeaveGroupEmployees() {
		return this.leaveGroupEmployees;
	}

	public void setLeaveGroupEmployees(Set<LeaveGroupEmployee> leaveGroupEmployees) {
		this.leaveGroupEmployees = leaveGroupEmployees;
	}

	public LeaveGroupEmployee addLeaveGroupEmployee(LeaveGroupEmployee leaveGroupEmployee) {
		getLeaveGroupEmployees().add(leaveGroupEmployee);
		leaveGroupEmployee.setLeaveGroupBean(this);

		return leaveGroupEmployee;
	}

	public LeaveGroupEmployee removeLeaveGroupEmployee(LeaveGroupEmployee leaveGroupEmployee) {
		getLeaveGroupEmployees().remove(leaveGroupEmployee);
		leaveGroupEmployee.setLeaveGroupBean(null);

		return leaveGroupEmployee;
	}

}