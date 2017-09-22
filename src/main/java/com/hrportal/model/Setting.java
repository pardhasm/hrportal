package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the Settings database table.
 * 
 */
@Entity
@Table(name="Settings")
//@NamedQuery(name="Setting.findAll", query="SELECT s FROM Setting s")
public class Setting extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	private String description;

	@Lob
	private String meta;

	@Column(nullable=false, length=100)
    @NotNull
    private String name;

	@Lob
	private String value;

	public Setting() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta() {
		return this.meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}