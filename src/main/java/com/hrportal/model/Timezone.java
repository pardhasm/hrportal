package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the Timezones database table.
 * 
 */
@Entity
@Table(name="Timezones")
//@NamedQuery(name="Timezone.findAll", query="SELECT t FROM Timezone t")
public class Timezone extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(nullable=false, length=255)
    @NotNull
    private String details;

	@Column(nullable=false, length=100)
    @NotNull
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