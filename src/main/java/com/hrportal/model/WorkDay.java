package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the WorkDays database table.
 * 
 */
@Entity
@Table(name="WorkDays")
//@NamedQuery(name="WorkDay.findAll", query="SELECT w FROM WorkDay w")
public class WorkDay extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    private Long country;

	@Column(nullable=false, length=100)
    @NotNull
    private String name;

	public WorkDay() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}