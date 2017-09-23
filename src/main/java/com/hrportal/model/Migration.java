package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the Migrations database table.
 * 
 */
@Entity
@Table(name="Migrations")
//@NamedQuery(name="Migration.findAll", query="SELECT m FROM Migration m")
public class Migration extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(nullable=false, length=50)
	private String file;

	@Column(name="last_error", length=500)
	private String lastError;

	@Column(length=20)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	@Column(nullable=false)
	private int version;

	public Migration() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
        this.created = created;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getLastError() {
		return this.lastError;
	}

	public void setLastError(String lastError) {
		this.lastError = lastError;
	}


    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}