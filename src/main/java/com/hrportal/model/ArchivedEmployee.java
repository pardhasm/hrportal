package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * The persistent class for the ArchivedEmployees database table.
 * 
 */
@Entity
@Table(name="ArchivedEmployees")
//@NamedQuery(name="ArchivedEmployee.findAll", query="SELECT a FROM ArchivedEmployee a")
public class ArchivedEmployee extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="confirmation_date")
	private Date confirmationDate;

	@Lob
	private String data;

    private Long department;

	@Column(name="employee_id", length=50)
	private String employeeId;

	@Column(name="first_name", nullable=false, length=100)
	private String firstName;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="joined_date")
	private Date joinedDate;

	@Column(name="last_name", nullable=false, length=100)
	private String lastName;

	@Column(name="nic_num", length=100)
	private String nicNum;

	@Lob
	private String notes;

	@Column(name="other_id", length=100)
	private String otherId;

	@Column(name="ref_id", nullable=false)
    private Long refId;

	@Column(name="ssn_num", length=100)
	private String ssnNum;

    private Long supervisor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="termination_date")
	private Date terminationDate;

	@Column(name="work_email", length=100)
	private String workEmail;

	public ArchivedEmployee() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getConfirmationDate() {
		return this.confirmationDate;
	}

	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

    public Long getDepartment() {
        return this.department;
	}

    public void setDepartment(Long department) {
        this.department = department;
	}

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getJoinedDate() {
		return this.joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNicNum() {
		return this.nicNum;
	}

	public void setNicNum(String nicNum) {
		this.nicNum = nicNum;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOtherId() {
		return this.otherId;
	}

	public void setOtherId(String otherId) {
		this.otherId = otherId;
	}

    public Long getRefId() {
        return this.refId;
	}

    public void setRefId(Long refId) {
        this.refId = refId;
	}

	public String getSsnNum() {
		return this.ssnNum;
	}

	public void setSsnNum(String ssnNum) {
		this.ssnNum = ssnNum;
	}

    public Long getSupervisor() {
        return this.supervisor;
	}

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
	}

	public Date getTerminationDate() {
		return this.terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getWorkEmail() {
		return this.workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

}