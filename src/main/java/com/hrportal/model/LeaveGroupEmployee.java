package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LeaveGroupEmployees database table.
 * 
 */
@Entity
@Table(name="LeaveGroupEmployees")
//@NamedQuery(name="LeaveGroupEmployee.findAll", query="SELECT l FROM LeaveGroupEmployee l")
public class LeaveGroupEmployee extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	//bi-directional many-to-one association to LeaveGroup
	@ManyToOne
	@JoinColumn(name="leave_group", nullable=false)
	private LeaveGroup leaveGroupBean;

	public LeaveGroupEmployee() {
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

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public LeaveGroup getLeaveGroupBean() {
		return this.leaveGroupBean;
	}

	public void setLeaveGroupBean(LeaveGroup leaveGroupBean) {
		this.leaveGroupBean = leaveGroupBean;
	}

}