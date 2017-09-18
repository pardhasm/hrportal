package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EmergencyContacts database table.
 * 
 */
@Entity
@Table(name="EmergencyContacts")
//@NamedQuery(name="EmergencyContact.findAll", query="SELECT e FROM EmergencyContact e")
public class EmergencyContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="home_phone", length=15)
	private String homePhone;

	@Column(name="mobile_phone", length=15)
	private String mobilePhone;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=100)
	private String relationship;

	@Column(name="work_phone", length=15)
	private String workPhone;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public EmergencyContact() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}