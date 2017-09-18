package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * The persistent class for the LeaveRules database table.
 * 
 */
@Entity
@Table(name="LeaveRules")
//@NamedQuery(name="LeaveRule.findAll", query="SELECT l FROM LeaveRule l")
public class LeaveRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="apply_beyond_current", length=20)
	private String applyBeyondCurrent;

	@Column(name="carried_forward", length=20)
	private String carriedForward;

	@Column(name="carried_forward_leave_availability")
	private int carriedForwardLeaveAvailability;

	@Column(name="carried_forward_percentage")
	private int carriedForwardPercentage;

	@Column(name="default_per_year", nullable=false, precision=10, scale=3)
	private BigDecimal defaultPerYear;

	private BigInteger employee;

	@Column(name="employee_can_apply", length=20)
	private String employeeCanApply;

	@Column(name="employment_status")
	private BigInteger employmentStatus;

	@Column(name="job_title")
	private BigInteger jobTitle;

	@Column(name="leave_accrue", length=20)
	private String leaveAccrue;

	@Column(name="leave_group")
	private BigInteger leaveGroup;

	@Column(name="leave_type", nullable=false)
	private BigInteger leaveType;

	@Column(name="max_carried_forward_amount")
	private int maxCarriedForwardAmount;

	@Column(name="propotionate_on_joined_date", length=20)
	private String propotionateOnJoinedDate;

	@Column(name="supervisor_leave_assign", length=20)
	private String supervisorLeaveAssign;

	public LeaveRule() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplyBeyondCurrent() {
		return this.applyBeyondCurrent;
	}

	public void setApplyBeyondCurrent(String applyBeyondCurrent) {
		this.applyBeyondCurrent = applyBeyondCurrent;
	}

	public String getCarriedForward() {
		return this.carriedForward;
	}

	public void setCarriedForward(String carriedForward) {
		this.carriedForward = carriedForward;
	}

	public int getCarriedForwardLeaveAvailability() {
		return this.carriedForwardLeaveAvailability;
	}

	public void setCarriedForwardLeaveAvailability(int carriedForwardLeaveAvailability) {
		this.carriedForwardLeaveAvailability = carriedForwardLeaveAvailability;
	}

	public int getCarriedForwardPercentage() {
		return this.carriedForwardPercentage;
	}

	public void setCarriedForwardPercentage(int carriedForwardPercentage) {
		this.carriedForwardPercentage = carriedForwardPercentage;
	}

	public BigDecimal getDefaultPerYear() {
		return this.defaultPerYear;
	}

	public void setDefaultPerYear(BigDecimal defaultPerYear) {
		this.defaultPerYear = defaultPerYear;
	}

	public BigInteger getEmployee() {
		return this.employee;
	}

	public void setEmployee(BigInteger employee) {
		this.employee = employee;
	}

	public String getEmployeeCanApply() {
		return this.employeeCanApply;
	}

	public void setEmployeeCanApply(String employeeCanApply) {
		this.employeeCanApply = employeeCanApply;
	}

	public BigInteger getEmploymentStatus() {
		return this.employmentStatus;
	}

	public void setEmploymentStatus(BigInteger employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public BigInteger getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(BigInteger jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLeaveAccrue() {
		return this.leaveAccrue;
	}

	public void setLeaveAccrue(String leaveAccrue) {
		this.leaveAccrue = leaveAccrue;
	}

	public BigInteger getLeaveGroup() {
		return this.leaveGroup;
	}

	public void setLeaveGroup(BigInteger leaveGroup) {
		this.leaveGroup = leaveGroup;
	}

	public BigInteger getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(BigInteger leaveType) {
		this.leaveType = leaveType;
	}

	public int getMaxCarriedForwardAmount() {
		return this.maxCarriedForwardAmount;
	}

	public void setMaxCarriedForwardAmount(int maxCarriedForwardAmount) {
		this.maxCarriedForwardAmount = maxCarriedForwardAmount;
	}

	public String getPropotionateOnJoinedDate() {
		return this.propotionateOnJoinedDate;
	}

	public void setPropotionateOnJoinedDate(String propotionateOnJoinedDate) {
		this.propotionateOnJoinedDate = propotionateOnJoinedDate;
	}

	public String getSupervisorLeaveAssign() {
		return this.supervisorLeaveAssign;
	}

	public void setSupervisorLeaveAssign(String supervisorLeaveAssign) {
		this.supervisorLeaveAssign = supervisorLeaveAssign;
	}

}