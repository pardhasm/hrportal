package com.hrportal.model;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the EmployeeCertifications database table.
 * 
 */
@Entity
@Table(name="EmployeeCertifications")
//@NamedQuery(name="EmployeeCertificationRepository.findAll", query="SELECT e FROM EmployeeCertificationRepository e")
public class EmployeeCertification extends AbstractMutableEntity{
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

	@Column(length=400)
	private String institute;

	//bi-directional many-to-one association to Certification
	@ManyToOne
	@JoinColumn(name="certification_id")
	private Certification certification;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public EmployeeCertification() {
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

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public Certification getCertification() {
		return this.certification;
	}

	public void setCertification(Certification certification) {
		this.certification = certification;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}