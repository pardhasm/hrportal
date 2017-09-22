package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the EmployeeTrainingSessions database table.
 * 
 */
@Entity
@Table(name="EmployeeTrainingSessions")
//@NamedQuery(name="EmployeeTrainingSession.findAll", query="SELECT e FROM EmployeeTrainingSession e")
public class EmployeeTrainingSession extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=1500)
	private String feedBack;

	@Column(length=300)
	private String proof;


	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
    @NotNull
    private Employee employeeBean;

	//bi-directional many-to-one association to TrainingSession
	@ManyToOne
	@JoinColumn(name="trainingSession")
	private TrainingSession trainingSessionBean;

	public EmployeeTrainingSession() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeedBack() {
		return this.feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getProof() {
		return this.proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}



	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public TrainingSession getTrainingSessionBean() {
		return this.trainingSessionBean;
	}

	public void setTrainingSessionBean(TrainingSession trainingSessionBean) {
		this.trainingSessionBean = trainingSessionBean;
	}

}