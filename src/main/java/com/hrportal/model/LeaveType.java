package com.hrportal.model;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the LeaveTypes database table.
 * 
 */
@Entity
@Table(name="LeaveTypes")
public class LeaveType extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="apply_beyond_current", length=20)
	private Polar applyBeyondCurrent;

	@Column(name="carried_forward", length=20)
    @Enumerated(EnumType.STRING)
	private Polar carriedForward;

	@Column(name="carried_forward_leave_availability")
	private int carriedForwardLeaveAvailability;

	@Column(name="carried_forward_percentage")
	private int carriedForwardPercentage;

	@Column(name="default_per_year", nullable=false, precision=10, scale=3)
	@Enumerated(EnumType.STRING)
	private Polar defaultPerYear;

	@Column(name="employee_can_apply", length=20)
	@Enumerated(EnumType.STRING)
	private Polar employeeCanApply;

	@Column(name="leave_accrue", length=20)
	@Enumerated(EnumType.STRING)
	private Polar leaveAccrue;

	@Column(name="leave_color", length=10)
	private String leaveColor;

	@Column(name="leave_group")
    private Long leaveGroup;

	@Column(name="max_carried_forward_amount")
	private int maxCarriedForwardAmount;

	@Column(nullable=false, length=100)
	private String name;

	@Column(name="propotionate_on_joined_date", length=20)
	@Enumerated(EnumType.STRING)
	private Polar propotionateOnJoinedDate;

	@Column(name="send_notification_emails", length=20)
	@Enumerated(EnumType.STRING)
	private Polar sendNotificationEmails;

	@Column(name="supervisor_leave_assign", length=20)
	private Polar supervisorLeaveAssign;

	//bi-directional many-to-one association to EmployeeLeave
	@OneToMany(mappedBy="leaveTypeBean", fetch=FetchType.EAGER)
	private Set<EmployeeLeave> employeeLeaves;

	public LeaveType() {
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getLeaveColor() {
		return this.leaveColor;
	}

	public void setLeaveColor(String leaveColor) {
		this.leaveColor = leaveColor;
	}

    public Long getLeaveGroup() {
        return this.leaveGroup;
	}

    public void setLeaveGroup(Long leaveGroup) {
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

	public Polar getApplyBeyondCurrent() {
		return applyBeyondCurrent;
	}

	public void setApplyBeyondCurrent(Polar applyBeyondCurrent) {
		this.applyBeyondCurrent = applyBeyondCurrent;
	}

	public Polar getCarriedForward() {
		return carriedForward;
	}

	public void setCarriedForward(Polar carriedForward) {
		this.carriedForward = carriedForward;
	}

	public Polar getDefaultPerYear() {
		return defaultPerYear;
	}

	public void setDefaultPerYear(Polar defaultPerYear) {
		this.defaultPerYear = defaultPerYear;
	}

	public Polar getEmployeeCanApply() {
		return employeeCanApply;
	}

	public void setEmployeeCanApply(Polar employeeCanApply) {
		this.employeeCanApply = employeeCanApply;
	}

	public Polar getLeaveAccrue() {
		return leaveAccrue;
	}

	public void setLeaveAccrue(Polar leaveAccrue) {
		this.leaveAccrue = leaveAccrue;
	}

	public Polar getPropotionateOnJoinedDate() {
		return propotionateOnJoinedDate;
	}

	public void setPropotionateOnJoinedDate(Polar propotionateOnJoinedDate) {
		this.propotionateOnJoinedDate = propotionateOnJoinedDate;
	}

	public Polar getSendNotificationEmails() {
		return sendNotificationEmails;
	}

	public void setSendNotificationEmails(Polar sendNotificationEmails) {
		this.sendNotificationEmails = sendNotificationEmails;
	}

	public Polar getSupervisorLeaveAssign() {
		return supervisorLeaveAssign;
	}

	public void setSupervisorLeaveAssign(Polar supervisorLeaveAssign) {
		this.supervisorLeaveAssign = supervisorLeaveAssign;
	}

	public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().remove(employeeLeave);
		employeeLeave.setLeaveTypeBean(null);

		return employeeLeave;
	}

}