package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the LeavePeriods database table.
 * 
 */
@Entity
@Table(name="LeavePeriods")
//@NamedQuery(name="LeavePeriod.findAll", query="SELECT l FROM LeavePeriod l")
public class LeavePeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_end")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="date_start")
	private Date dateStart;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)
	private String status;

	//bi-directional many-to-one association to EmployeeLeave
	@OneToMany(mappedBy="leavePeriodBean", fetch=FetchType.EAGER)
	private Set<EmployeeLeave> employeeLeaves;

	public LeavePeriod() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<EmployeeLeave> getEmployeeLeaves() {
		return this.employeeLeaves;
	}

	public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	public EmployeeLeave addEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().add(employeeLeave);
		employeeLeave.setLeavePeriodBean(this);

		return employeeLeave;
	}

	public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeave) {
		getEmployeeLeaves().remove(employeeLeave);
		employeeLeave.setLeavePeriodBean(null);

		return employeeLeave;
	}

}