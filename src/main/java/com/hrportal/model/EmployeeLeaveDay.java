package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeLeaveDays database table.
 * 
 */
@Entity
@Table(name="EmployeeLeaveDays")
//@NamedQuery(name="EmployeeLeaveDay.findAll", query="SELECT e FROM EmployeeLeaveDay e")
public class EmployeeLeaveDay extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="leave_date")
    private DateTime leaveDate;

	@Column(name="leave_type", nullable=false, length=200)
    @NotNull
    @Enumerated(EnumType.STRING)
	private LeaveTypes leaveType;

	//bi-directional many-to-one association to EmployeeLeave
	@ManyToOne
	@JoinColumn(name="employee_leave", nullable=false)
    @NotNull
    private EmployeeLeave employeeLeaveBean;

	public EmployeeLeaveDay() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public DateTime getLeaveDate() {
        return this.leaveDate;
	}

    public void setLeaveDate(DateTime leaveDate) {
        this.leaveDate = leaveDate;
	}

	public LeaveTypes getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(LeaveTypes leaveType) {
		this.leaveType = leaveType;
	}

	public EmployeeLeave getEmployeeLeaveBean() {
		return this.employeeLeaveBean;
	}

	public void setEmployeeLeaveBean(EmployeeLeave employeeLeaveBean) {
		this.employeeLeaveBean = employeeLeaveBean;
	}

}