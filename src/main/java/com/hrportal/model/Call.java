package com.hrportal.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Call extends AbstractMutableEntity  {
	
	@Id 
	@NotNull
	@Length(max = 20)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(unique=true)
	@Length(max = 20)
	private long job;
	
	@Column(unique=true)
	@Length(max = 20)
	@OneToOne
	@JoinColumn(table = "Candidates", referencedColumnName = "id")
	private Candidate candidate;
	
	@Length(max = 20)
	private long phone;
	
	@Length(max = 100)
	private String status;
	
	private String notes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getJob() {
		return job;
	}

	public void setJob(long job) {
		this.job = job;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	

}
