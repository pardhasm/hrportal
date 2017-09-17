package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Interviews")
public class Interview extends AbstractMutableEntity {

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

    @Length(max = 100)
    private String level;

    private Date scheduled;

    @Length(max = 500)
    private String location;

    @Length(max = 20)
    private Long mapId;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getScheduled() {
        return scheduled;
    }

    public void setScheduled(Date scheduled) {
        this.scheduled = scheduled;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getMapId() {
        return mapId;
    }

    public void setMapId(Long mapId) {
        this.mapId = mapId;
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
