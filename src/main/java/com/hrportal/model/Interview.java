package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the Interviews database table.
 */
@Entity
@Table(name = "Interviews")
//@NamedQuery(name="Interview.findAll", query="SELECT i FROM Interview i")
public class Interview extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @Column(length = 100)
    private String level;

    @Column(length = 500)
    private String location;

    private Long mapId;

    @Lob
    private String notes;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime scheduled;

    @Column(length = 100)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

    //bi-directional many-to-one association to Candidate
    @ManyToOne
    @JoinColumn(name = "candidate")
    private Candidate candidateBean;

    //bi-directional many-to-one association to Job
    @ManyToOne
    @JoinColumn(name = "job", nullable = false)
    @NotNull
    private Job jobBean;

    public Interview() {
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

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getMapId() {
        return this.mapId;
    }

    public void setMapId(Long mapId) {
        this.mapId = mapId;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public DateTime getScheduled() {
        return this.scheduled;
    }

    public void setScheduled(DateTime scheduled) {
        this.scheduled = scheduled;
    }


    public DateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
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