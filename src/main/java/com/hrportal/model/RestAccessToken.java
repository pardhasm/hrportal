package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the RestAccessTokens database table.
 * 
 */
@Entity
@Table(name="RestAccessTokens")
//@NamedQuery(name="RestAccessToken.findAll", query="SELECT r FROM RestAccessToken r")
public class RestAccessToken extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(length=32)
	private String hash;

	@Column(length=500)
	private String token;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	@Column(nullable=false)
    @NotNull
    private Long userId;

	public RestAccessToken() {
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

    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

    public Long getUserId() {
        return this.userId;
	}

    public void setUserId(Long userId) {
        this.userId = userId;
	}

}