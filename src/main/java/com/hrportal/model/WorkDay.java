package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the WorkDays database table.
 * 
 */
@Entity
@Table(name="WorkDays")
//@NamedQuery(name="WorkDay.findAll", query="SELECT w FROM WorkDay w")
public class WorkDay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private BigInteger country;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)
	private String status;

	public WorkDay() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigInteger getCountry() {
		return this.country;
	}

	public void setCountry(BigInteger country) {
		this.country = country;
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

}