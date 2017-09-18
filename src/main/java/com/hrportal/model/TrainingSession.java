package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the TrainingSessions database table.
 * 
 */
@Entity
@Table(name="TrainingSessions")
//@NamedQuery(name="TrainingSession.findAll", query="SELECT t FROM TrainingSession t")
public class TrainingSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=300)
	private String attachment;

	@Column(length=20)
	private String attendanceType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=500)
	private String deliveryLocation;

	@Column(length=20)
	private String deliveryMethod;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;

	@Column(nullable=false, length=300)
	private String name;

	@Column(length=20)
	private String requireProof;

	@Temporal(TemporalType.TIMESTAMP)
	private Date scheduled;

	@Column(length=20)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to EmployeeTrainingSession
	@OneToMany(mappedBy="trainingSessionBean", fetch=FetchType.EAGER)
	private Set<EmployeeTrainingSession> employeeTrainingSessions;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="course", nullable=false)
	private Cours cours;

	public TrainingSession() {
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

	public String getAttendanceType() {
		return this.attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDeliveryLocation() {
		return this.deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public String getDeliveryMethod() {
		return this.deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequireProof() {
		return this.requireProof;
	}

	public void setRequireProof(String requireProof) {
		this.requireProof = requireProof;
	}

	public Date getScheduled() {
		return this.scheduled;
	}

	public void setScheduled(Date scheduled) {
		this.scheduled = scheduled;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Set<EmployeeTrainingSession> getEmployeeTrainingSessions() {
		return this.employeeTrainingSessions;
	}

	public void setEmployeeTrainingSessions(Set<EmployeeTrainingSession> employeeTrainingSessions) {
		this.employeeTrainingSessions = employeeTrainingSessions;
	}

	public EmployeeTrainingSession addEmployeeTrainingSession(EmployeeTrainingSession employeeTrainingSession) {
		getEmployeeTrainingSessions().add(employeeTrainingSession);
		employeeTrainingSession.setTrainingSessionBean(this);

		return employeeTrainingSession;
	}

	public EmployeeTrainingSession removeEmployeeTrainingSession(EmployeeTrainingSession employeeTrainingSession) {
		getEmployeeTrainingSessions().remove(employeeTrainingSession);
		employeeTrainingSession.setTrainingSessionBean(null);

		return employeeTrainingSession;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

}