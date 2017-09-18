package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;



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
    @Enumerated(EnumType.STRING)
	private Polar applyBeyondCurrent;

	@Column(name="carried_forward", length=20)
    @Enumerated(EnumType.STRING)
	private Polar carriedForward;

	@Column(name="carried_forward_leave_availability")
	private int carriedForwardLeaveAvailability;

	@Column(name="carried_forward_percentage")
	private int carriedForwardPercentage;

	@Column(name="default_per_year", nullable=false, precision=10, scale=3)
	private BigDecimal defaultPerYear;

    private Long employee;

	@Column(name="employee_can_apply", length=20)
    @Enumerated(EnumType.STRING)
	private Polar employeeCanApply;

	@Column(name="employment_status")
    private Long employmentStatus;

	@Column(name="job_title")
    private Long jobTitle;

	@Column(name="leave_accrue", length=20)
    @Enumerated(EnumType.STRING)
	private Polar leaveAccrue;

	@Column(name="leave_group")
    private Long leaveGroup;

	@Column(name="leave_type", nullable=false)
    private Long leaveType;

	@Column(name="max_carried_forward_amount")
	private int maxCarriedForwardAmount;

	@Column(name="propotionate_on_joined_date", length=20)
    @Enumerated(EnumType.STRING)
	private Polar propotionateOnJoinedDate;

	@Column(name="supervisor_leave_assign", length=20)
    @Enumerated(EnumType.STRING)
	private Polar supervisorLeaveAssign;

	public LeaveRule() {
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

	public BigDecimal getDefaultPerYear() {
		return this.defaultPerYear;
	}

	public void setDefaultPerYear(BigDecimal defaultPerYear) {
		this.defaultPerYear = defaultPerYear;
	}

    public Long getEmployee() {
        return this.employee;
	}

    public void setEmployee(Long employee) {
        this.employee = employee;
	}

	public Long getEmploymentStatus() {
        return this.employmentStatus;
	}

    public void setEmploymentStatus(Long employmentStatus) {
        this.employmentStatus = employmentStatus;
	}

    public Long getJobTitle() {
        return this.jobTitle;
	}

    public void setJobTitle(Long jobTitle) {
        this.jobTitle = jobTitle;
	}

	public Long getLeaveGroup() {
        return this.leaveGroup;
	}

    public void setLeaveGroup(Long leaveGroup) {
        this.leaveGroup = leaveGroup;
	}

    public Long getLeaveType() {
        return this.leaveType;
	}

    public void setLeaveType(Long leaveType) {
        this.leaveType = leaveType;
	}

	public int getMaxCarriedForwardAmount() {
		return this.maxCarriedForwardAmount;
	}

	public void setMaxCarriedForwardAmount(int maxCarriedForwardAmount) {
		this.maxCarriedForwardAmount = maxCarriedForwardAmount;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Polar getSupervisorLeaveAssign() {
        return supervisorLeaveAssign;
    }

    public void setSupervisorLeaveAssign(Polar supervisorLeaveAssign) {
        this.supervisorLeaveAssign = supervisorLeaveAssign;
    }
}