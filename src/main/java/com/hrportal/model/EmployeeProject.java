package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the EmployeeProjects database table.
 * 
 */
@Entity
@Table(name="EmployeeProjects")
//@NamedQuery(name="EmployeeProject.findAll", query="SELECT e FROM EmployeeProject e")
public class EmployeeProject extends AbstractMutableEntity{
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

	@Lob
	private String details;


	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="project")
	private Project projectBean;

	public EmployeeProject() {
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}



	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public Project getProjectBean() {
		return this.projectBean;
	}

	public void setProjectBean(Project projectBean) {
		this.projectBean = projectBean;
	}

}