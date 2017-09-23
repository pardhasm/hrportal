package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;



/**
 * The persistent class for the HoliDays database table.
 * 
 */
@Entity
@Table(name="HoliDays")
//@NamedQuery(name="HoliDay.findAll", query="SELECT h FROM HoliDay h")
public class HoliDay extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	private Long country;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime dateh;

	@Column(nullable=false, length=100)
	private String name;


	public HoliDay() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCountry() {
		return this.country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

    public DateTime getDateh() {
        return this.dateh;
	}

    public void setDateh(DateTime dateh) {
        this.dateh = dateh;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}