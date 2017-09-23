package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the Applications database table.
 */
@Entity
@Table(name = "Applications")
public class Application extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Lob
	private String notes;

	@Column(length = 200)
	private String referredByEmail;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name = "candidate")
	private Candidate candidateBean;

	//bi-directional many-to-one association to Job
	@ManyToOne
    @JoinColumn(name = "job", nullable = false)
    @NotNull
    private Job jobBean;

	public Application() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
        this.created = created;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReferredByEmail() {
		return this.referredByEmail;
	}

	public void setReferredByEmail(String referredByEmail) {
		this.referredByEmail = referredByEmail;
	}

	public Candidate getCandidateBean() {
		return this.candidateBean;
	}

	public void setCandidateBean(Candidate candidateBean) {
		this.candidateBean = candidateBean;
	}

	public Job getJobBean() {
		return this.jobBean;
	}

	public void setJobBean(Job jobBean) {
		this.jobBean = jobBean;
	}

}