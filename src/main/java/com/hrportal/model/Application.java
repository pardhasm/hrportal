package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Applications")
public class Application extends AbstractMutableEntity {

	@Id 
	@NotNull
	@Length(max = 20)
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Length(max = 20)
    @OneToOne
    @JoinColumn(table = "Jobs", referencedColumnName = "id")
    private Job job;

    @Length(max = 20)
	@OneToOne
	@JoinColumn(table = "Candidates", referencedColumnName = "id")
	private Candidate candidate;
	
	private Date created;
	
	@Length(max = 200)
	private String referredByEmail;
	private String notes;

    public Long getId() {
        return id;
	}

    public void setId(Long id) {
        this.id = id;
	}

    public Job getJob() {
        return job;
	}

    public void setJob(Job job) {
        this.job = job;
	}

    public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getReferredByEmail() {
		return referredByEmail;
	}
	public void setReferredByEmail(String referredByEmail) {
		this.referredByEmail = referredByEmail;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
}
