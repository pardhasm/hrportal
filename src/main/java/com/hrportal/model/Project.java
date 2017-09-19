package com.hrportal.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Projects database table.
 * 
 */
@Entity
@Table(name="Projects")
//@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Lob
	private String details;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)


	//bi-directional many-to-one association to EmployeeProject
	@OneToMany(mappedBy="projectBean", fetch=FetchType.EAGER)
	private Set<EmployeeProject> employeeProjects;

	//bi-directional many-to-one association to EmployeeTimeEntry
	@OneToMany(mappedBy="projectBean", fetch=FetchType.EAGER)
	private Set<EmployeeTimeEntry> employeeTimeEntries;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="client")
	private Client clientBean;

	public Project() {
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Set<EmployeeProject> getEmployeeProjects() {
		return this.employeeProjects;
	}

	public void setEmployeeProjects(Set<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public EmployeeProject addEmployeeProject(EmployeeProject employeeProject) {
		getEmployeeProjects().add(employeeProject);
		employeeProject.setProjectBean(this);

		return employeeProject;
	}

	public EmployeeProject removeEmployeeProject(EmployeeProject employeeProject) {
		getEmployeeProjects().remove(employeeProject);
		employeeProject.setProjectBean(null);

		return employeeProject;
	}

	public Set<EmployeeTimeEntry> getEmployeeTimeEntries() {
		return this.employeeTimeEntries;
	}

	public void setEmployeeTimeEntries(Set<EmployeeTimeEntry> employeeTimeEntries) {
		this.employeeTimeEntries = employeeTimeEntries;
	}

	public EmployeeTimeEntry addEmployeeTimeEntry(EmployeeTimeEntry employeeTimeEntry) {
		getEmployeeTimeEntries().add(employeeTimeEntry);
		employeeTimeEntry.setProjectBean(this);

		return employeeTimeEntry;
	}

	public EmployeeTimeEntry removeEmployeeTimeEntry(EmployeeTimeEntry employeeTimeEntry) {
		getEmployeeTimeEntries().remove(employeeTimeEntry);
		employeeTimeEntry.setProjectBean(null);

		return employeeTimeEntry;
	}

	public Client getClientBean() {
		return this.clientBean;
	}

	public void setClientBean(Client clientBean) {
		this.clientBean = clientBean;
	}

}