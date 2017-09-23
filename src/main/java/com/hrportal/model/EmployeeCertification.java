package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


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

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_end")
    private DateTime dateEnd;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_start")
    private DateTime dateStart;

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

    public DateTime getDateEnd() {
        return this.dateEnd;
	}

    public void setDateEnd(DateTime dateEnd) {
        this.dateEnd = dateEnd;
	}

    public DateTime getDateStart() {
        return this.dateStart;
	}

    public void setDateStart(DateTime dateStart) {
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