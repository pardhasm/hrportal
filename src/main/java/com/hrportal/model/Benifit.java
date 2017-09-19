package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the Benifits database table.
 * 
 */
@Entity
@Table(name = "Benifits")
//@NamedQuery(name="Benifit.findAll", query="SELECT b FROM Benifit b")
public class Benifit extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 250)
	private String name;

	public Benifit() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}