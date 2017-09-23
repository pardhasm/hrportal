package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


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

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

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

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
        this.created = created;
	}

    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
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