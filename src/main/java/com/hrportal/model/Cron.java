package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the Crons database table.
 * 
 */
@Entity
@Table(name="Crons")
//@NamedQuery(name="Cron.findAll", query="SELECT c FROM Cron c")
public class Cron extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="class", nullable=false, length=100)
    @NotNull
    private String class_;

	@Column(nullable=false)
	private int frequency;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime lastrun;

	@Column(nullable=false, length=100)
    @NotNull
    private String name;


	@Column(nullable=false, length=50)
    @NotNull
    private String time;

	@Column(length=20)
	private String type;

	public Cron() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public int getFrequency() {
		return this.frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

    public DateTime getLastrun() {
        return this.lastrun;
	}

    public void setLastrun(DateTime lastrun) {
        this.lastrun = lastrun;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}