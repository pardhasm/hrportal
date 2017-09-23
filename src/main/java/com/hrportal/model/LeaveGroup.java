package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the LeaveGroups database table.
 * 
 */
@Entity
@Table(name="LeaveGroups")
//@NamedQuery(name="LeaveGroup.findAll", query="SELECT l FROM LeaveGroup l")
public class LeaveGroup extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

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

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
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

    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
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