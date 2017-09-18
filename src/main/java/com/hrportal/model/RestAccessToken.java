package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



/**
 * The persistent class for the RestAccessTokens database table.
 * 
 */
@Entity
@Table(name="RestAccessTokens")
//@NamedQuery(name="RestAccessToken.findAll", query="SELECT r FROM RestAccessToken r")
public class RestAccessToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(length=32)
	private String hash;

	@Column(length=500)
	private String token;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Column(nullable=false)
    private Long userId;

	public RestAccessToken() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

    public Long getUserId() {
        return this.userId;
	}

    public void setUserId(Long userId) {
        this.userId = userId;
	}

}