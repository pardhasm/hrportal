package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Crons database table.
 * 
 */
@Entity
@Table(name="Crons")
//@NamedQuery(name="Cron.findAll", query="SELECT c FROM Cron c")
public class Cron implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="class", nullable=false, length=100)
	private String class_;

	@Column(nullable=false)
	private int frequency;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastrun;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)
	private String status;

	@Column(nullable=false, length=50)
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

	public Date getLastrun() {
		return this.lastrun;
	}

	public void setLastrun(Date lastrun) {
		this.lastrun = lastrun;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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