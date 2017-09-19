package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DataEntryBackups database table.
 * 
 */
@Entity
@Table(name="DataEntryBackups")
//@NamedQuery(name="DataEntryBackup.findAll", query="SELECT d FROM DataEntryBackup d")
public class DataEntryBackup extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	private String data;

	@Column(length=200)
	private String tableType;

	public DataEntryBackup() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTableType() {
		return this.tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

}