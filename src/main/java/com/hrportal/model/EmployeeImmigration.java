package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;


/**
 * The persistent class for the EmployeeImmigrations database table.
 * 
 */
@Entity
@Table(name="EmployeeImmigrations")
//@NamedQuery(name="EmployeeImmigration.findAll", query="SELECT e FROM EmployeeImmigration e")
public class EmployeeImmigration extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=100)
	private String attachment1;

	@Column(length=100)
	private String attachment2;

	@Column(length=100)
	private String attachment3;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Lob
	private String details;

	@Column(nullable=false, length=150)
	private String documentname;

	@Column(length=20)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="valid_until", nullable=false)
    private DateTime validUntil;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	//bi-directional many-to-one association to ImmigrationDocument
	@ManyToOne
	@JoinColumn(name="document")
	private ImmigrationDocument immigrationDocument;

	public EmployeeImmigration() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttachment1() {
		return this.attachment1;
	}

	public void setAttachment1(String attachment1) {
		this.attachment1 = attachment1;
	}

	public String getAttachment2() {
		return this.attachment2;
	}

	public void setAttachment2(String attachment2) {
		this.attachment2 = attachment2;
	}

	public String getAttachment3() {
		return this.attachment3;
	}

	public void setAttachment3(String attachment3) {
		this.attachment3 = attachment3;
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

	public String getDocumentname() {
		return this.documentname;
	}

	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}


    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

    public DateTime getValidUntil() {
        return this.validUntil;
	}

    public void setValidUntil(DateTime validUntil) {
        this.validUntil = validUntil;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public ImmigrationDocument getImmigrationDocument() {
		return this.immigrationDocument;
	}

	public void setImmigrationDocument(ImmigrationDocument immigrationDocument) {
		this.immigrationDocument = immigrationDocument;
	}

}