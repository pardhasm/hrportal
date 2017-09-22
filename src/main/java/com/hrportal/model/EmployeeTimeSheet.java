package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the EmployeeTimeSheets database table.
 * 
 */
@Entity
@Table(name="EmployeeTimeSheets")
//@NamedQuery(name="EmployeeTimeSheet.findAll", query="SELECT e FROM EmployeeTimeSheet e")
public class EmployeeTimeSheet extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_end", nullable=false)
    @NotNull
    private DateTime dateEnd;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="date_start", nullable=false)
    @NotNull
    private DateTime dateStart;

	@Column(length=20)


	//bi-directional many-to-one association to EmployeeTimeEntry
	@OneToMany(mappedBy="employeeTimeSheet", fetch=FetchType.EAGER)
	private Set<EmployeeTimeEntry> employeeTimeEntries;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee", nullable=false)
	private Employee employeeBean;

	public EmployeeTimeSheet() {
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



	public Set<EmployeeTimeEntry> getEmployeeTimeEntries() {
		return this.employeeTimeEntries;
	}

	public void setEmployeeTimeEntries(Set<EmployeeTimeEntry> employeeTimeEntries) {
		this.employeeTimeEntries = employeeTimeEntries;
	}

	public EmployeeTimeEntry addEmployeeTimeEntry(EmployeeTimeEntry employeeTimeEntry) {
		getEmployeeTimeEntries().add(employeeTimeEntry);
		employeeTimeEntry.setEmployeeTimeSheet(this);

		return employeeTimeEntry;
	}

	public EmployeeTimeEntry removeEmployeeTimeEntry(EmployeeTimeEntry employeeTimeEntry) {
		getEmployeeTimeEntries().remove(employeeTimeEntry);
		employeeTimeEntry.setEmployeeTimeSheet(null);

		return employeeTimeEntry;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

}