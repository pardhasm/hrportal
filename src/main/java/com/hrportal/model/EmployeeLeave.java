package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the EmployeeLeaves database table.
 * 
 */
@Entity
@Table(name="EmployeeLeaves")
//@NamedQuery(name="EmployeeLeave.findAll", query="SELECT e FROM EmployeeLeave e")
public class EmployeeLeave extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String attachment;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_end")
    private DateTime dateEnd;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_start")
    private DateTime dateStart;

	@Lob
	private String details;

	@Column(length=20)


	//bi-directional many-to-one association to EmployeeLeaveDay
	@OneToMany(mappedBy="employeeLeaveBean", fetch=FetchType.EAGER)
	private Set<EmployeeLeaveDay> employeeLeaveDays;

	//bi-directional many-to-one association to EmployeeLeaveLog
	@OneToMany(mappedBy="employeeLeaveBean", fetch=FetchType.EAGER)
	private Set<EmployeeLeaveLog> employeeLeaveLogs;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
    @NotNull
    private Employee employeeBean;

	//bi-directional many-to-one association to LeavePeriod
	@ManyToOne
	@JoinColumn(name="leave_period", nullable=false)
    @NotNull
    private LeavePeriod leavePeriodBean;

	//bi-directional many-to-one association to LeaveType
	@ManyToOne
	@JoinColumn(name="leave_type", nullable=false)
	private LeaveType leaveTypeBean;

	public EmployeeLeave() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

    public DateTime getDateEnd() {
        return this.dateEnd;
	}

    public void setDateEnd(DateTime dateEnd) {
        this.dateEnd = dateEnd;
	}

    public DateTime getDateStart() {
        return this.dateStart;
	}

    public void setDateStart(DateTime dateStart) {
        this.dateStart = dateStart;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}



	public Set<EmployeeLeaveDay> getEmployeeLeaveDays() {
		return this.employeeLeaveDays;
	}

	public void setEmployeeLeaveDays(Set<EmployeeLeaveDay> employeeLeaveDays) {
		this.employeeLeaveDays = employeeLeaveDays;
	}

	public EmployeeLeaveDay addEmployeeLeaveDay(EmployeeLeaveDay employeeLeaveDay) {
		getEmployeeLeaveDays().add(employeeLeaveDay);
		employeeLeaveDay.setEmployeeLeaveBean(this);

		return employeeLeaveDay;
	}

	public EmployeeLeaveDay removeEmployeeLeaveDay(EmployeeLeaveDay employeeLeaveDay) {
		getEmployeeLeaveDays().remove(employeeLeaveDay);
		employeeLeaveDay.setEmployeeLeaveBean(null);

		return employeeLeaveDay;
	}

	public Set<EmployeeLeaveLog> getEmployeeLeaveLogs() {
		return this.employeeLeaveLogs;
	}

	public void setEmployeeLeaveLogs(Set<EmployeeLeaveLog> employeeLeaveLogs) {
		this.employeeLeaveLogs = employeeLeaveLogs;
	}

	public EmployeeLeaveLog addEmployeeLeaveLog(EmployeeLeaveLog employeeLeaveLog) {
		getEmployeeLeaveLogs().add(employeeLeaveLog);
		employeeLeaveLog.setEmployeeLeaveBean(this);

		return employeeLeaveLog;
	}

	public EmployeeLeaveLog removeEmployeeLeaveLog(EmployeeLeaveLog employeeLeaveLog) {
		getEmployeeLeaveLogs().remove(employeeLeaveLog);
		employeeLeaveLog.setEmployeeLeaveBean(null);

		return employeeLeaveLog;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public LeavePeriod getLeavePeriodBean() {
		return this.leavePeriodBean;
	}

	public void setLeavePeriodBean(LeavePeriod leavePeriodBean) {
		this.leavePeriodBean = leavePeriodBean;
	}

	public LeaveType getLeaveTypeBean() {
		return this.leaveTypeBean;
	}

	public void setLeaveTypeBean(LeaveType leaveTypeBean) {
		this.leaveTypeBean = leaveTypeBean;
	}

}