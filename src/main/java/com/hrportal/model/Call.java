package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Calls")
public class Call extends AbstractMutableEntity  {

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

    @Length(max = 20)
    private Long phone;

    @Length(max = 100)
    private String status;

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
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
