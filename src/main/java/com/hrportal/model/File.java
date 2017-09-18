package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;



/**
 * The persistent class for the Files database table.
 * 
 */
@Entity
@Table(name="Files")
//@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    private Long employee;

	@Column(name="file_group", nullable=false, length=100)
	private String fileGroup;

	@Column(nullable=false, length=100)
	private String filename;

	@Column(nullable=false, length=100)
	private String name;

    private Long size;

	@Column(name="size_text", length=20)
	private String sizeText;

	public File() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Long getEmployee() {
        return this.employee;
	}

    public void setEmployee(Long employee) {
        this.employee = employee;
	}

	public String getFileGroup() {
		return this.fileGroup;
	}

	public void setFileGroup(String fileGroup) {
		this.fileGroup = fileGroup;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Long getSize() {
        return this.size;
	}

    public void setSize(Long size) {
        this.size = size;
	}

	public String getSizeText() {
		return this.sizeText;
	}

	public void setSizeText(String sizeText) {
		this.sizeText = sizeText;
	}

}