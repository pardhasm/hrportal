package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Timezones database table.
 * 
 */
@Entity
@Table(name="Timezones")
//@NamedQuery(name="Timezone.findAll", query="SELECT t FROM Timezone t")
public class Timezone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=255)
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	public Timezone() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}