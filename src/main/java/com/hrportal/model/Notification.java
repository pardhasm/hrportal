package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the Notifications database table.
 * 
 */
@Entity
@Table(name="Notifications")
//@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	private String action;

	private BigInteger employee;

	private BigInteger fromEmployee;

	private BigInteger fromUser;

	@Column(length=500)
	private String image;

	@Lob
	private String message;

	@Column(length=20)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@Column(length=100)
	private String type;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="toUser", nullable=false)
	private User user;

	public Notification() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public BigInteger getEmployee() {
		return this.employee;
	}

	public void setEmployee(BigInteger employee) {
		this.employee = employee;
	}

	public BigInteger getFromEmployee() {
		return this.fromEmployee;
	}

	public void setFromEmployee(BigInteger fromEmployee) {
		this.fromEmployee = fromEmployee;
	}

	public BigInteger getFromUser() {
		return this.fromUser;
	}

	public void setFromUser(BigInteger fromUser) {
		this.fromUser = fromUser;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}