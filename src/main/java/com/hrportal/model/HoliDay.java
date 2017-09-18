package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the HoliDays database table.
 * 
 */
@Entity
@Table(name="HoliDays")
//@NamedQuery(name="HoliDay.findAll", query="SELECT h FROM HoliDay h")
public class HoliDay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private BigInteger country;

	@Temporal(TemporalType.DATE)
	private Date dateh;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)
	private String status;

	public HoliDay() {
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

	public Date getDateh() {
		return this.dateh;
	}

	public void setDateh(Date dateh) {
		this.dateh = dateh;
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