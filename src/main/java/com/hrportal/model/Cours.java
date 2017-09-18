package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Courses database table.
 * 
 */
@Entity
@Table(name="Courses")
//@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=300)
	private String code;

	@Column(precision=10, scale=2)
	private BigDecimal cost;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=3)
	private String currency;

	@Lob
	private String description;

	@Column(nullable=false, length=300)
	private String name;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@Column(length=20)
	private String status;

	@Column(length=300)
	private String trainer;

	@Lob
	@Column(name="trainer_info")
	private String trainerInfo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="coordinator")
	private Employee employee;

	//bi-directional many-to-one association to TrainingSession
	@OneToMany(mappedBy="cours", fetch=FetchType.EAGER)
	private Set<TrainingSession> trainingSessions;

	public Cours() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PaymentType getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrainer() {
		return this.trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getTrainerInfo() {
		return this.trainerInfo;
	}

	public void setTrainerInfo(String trainerInfo) {
		this.trainerInfo = trainerInfo;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<TrainingSession> getTrainingSessions() {
		return this.trainingSessions;
	}

	public void setTrainingSessions(Set<TrainingSession> trainingSessions) {
		this.trainingSessions = trainingSessions;
	}

	public TrainingSession addTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().add(trainingSession);
		trainingSession.setCours(this);

		return trainingSession;
	}

	public TrainingSession removeTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().remove(trainingSession);
		trainingSession.setCours(null);

		return trainingSession;
	}

}