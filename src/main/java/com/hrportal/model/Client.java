package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the Clients database table.
 * 
 */
@Entity
@Table(name="Clients")
//@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Lob
	private String address;

	@Column(name="company_url", length=500)
	private String companyUrl;

	@Column(name="contact_email", length=100)
	private String contactEmail;

	@Column(name="contact_number", length=25)
	private String contactNumber;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Lob
	private String details;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="first_contact_date")
    private DateTime firstContactDate;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)


	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="clientBean", fetch=FetchType.EAGER)
	private Set<Project> projects;

	public Client() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyUrl() {
		return this.companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
        this.created = created;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

    public DateTime getFirstContactDate() {
        return this.firstContactDate;
	}

    public void setFirstContactDate(DateTime firstContactDate) {
        this.firstContactDate = firstContactDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setClientBean(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setClientBean(null);

		return project;
	}

}