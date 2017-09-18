package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;


/**
 * The persistent class for the LeaveTypes database table.
 * 
 */
@Entity
@Table(name="LeaveTypes")
//@NamedQuery(name="LeaveType.findAll", query="SELECT l FROM LeaveType l")
public class LeaveType implements Serializable {
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

	@Column(name="employee_can_apply", length=20)
	private String employeeCanApply;

	@Column(name="leave_accrue", length=20)
	private String leaveAccrue;

	@Column(name="leave_color", length=10)
	private String leaveColor;

	@Column(name="leave_group")
	private BigInteger leaveGroup;

	@Column(name="max_carried_forward_amount")
	private int maxCarriedForwardAmount;

	@Column(nullable=false, length=100)
	private String name;

	@Column(name="propotionate_on_joined_date", length=20)
	private String propotionateOnJoinedDate;

	@Column(name="send_notification_emails", length=20)
	private String sendNotificationEmails;

	@Column(name="supervisor_leave_assign", length=20)
	private String supervisorLeaveAssign;

	//bi-directional many-to-one association to EmployeeLeave
	@OneToMany(mappedBy="leaveTypeBean", fetch=FetchType.EAGER)
	private Set<EmployeeLeave> employeeLeaves;

	public LeaveType() {
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

	public String getEmployeeCanApply() {
		return this.employeeCanApply;
	}

	public void setEmployeeCanApply(String employeeCanApply) {
		this.employeeCanApply = employeeCanApply;
	}

	public String getLeaveAccrue() {
		return this.leaveAccrue;
	}

	public void setLeaveAccrue(String leaveAccrue) {
		this.leaveAccrue = leaveAccrue;
	}

	public String getLeaveColor() {
		return this.leaveColor;
	}

	public void setLeaveColor(String leaveColor) {
		this.leaveColor = leaveColor;
	}

	public BigInteger getLeaveGroup() {
		return this.leaveGroup;
	}

	public void setLeaveGroup(BigInteger leaveGroup) {
		this.leaveGroup = leaveGroup;
	}

	public int getMaxCarriedForwardAmount() {
		return this.maxCarriedForwardAmount;
	}

	public void setMaxCarriedForwardAmount(int maxCarriedForwardAmount) {
		this.maxCarriedForwardAmount = maxCarriedForwardAmount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPropotionateOnJoinedDate() {
		return this.propotionateOnJoinedDate;
	}

	public void setPropotionateOnJoinedDate(String propotionateOnJoinedDate) {
		this.propotionateOnJoinedDate = propotionateOnJoinedDate;
	}

	public String getSendNotificationEmails() {
		return this.sendNotificationEmails;
	}

	public void setSendNotificationEmails(String sendNotificationEmails) {
		this.sendNotificationEmails = sendNotificationEmails;
	}

	public String getSupervisorLeaveAssign() {
		return this.supervisorLeaveAssign;
	}

	public void setSupervisorLeaveAssign(String supervisorLeaveAssign) {
		this.supervisorLeaveAssign = supervisorLeaveAssign;
	}

	public Set<EmployeeLeave> getEmployeeLeaves() {
		return this.employeeLeaves;
	}

	public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	public EmployeeLeave addEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().add(employeeLeave);
		employeeLeave.setLeaveTypeBean(this);

		return employeeLeave;
	}

	public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().remove(employeeLeave);
		employeeLeave.setLeaveTypeBean(null);

		return employeeLeave;
	}

}