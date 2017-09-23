package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the LeavePeriods database table.
 * 
 */
@Entity
@Table(name="LeavePeriods")
//@NamedQuery(name="LeavePeriod.findAll", query="SELECT l FROM LeavePeriod l")
public class LeavePeriod extends AbstractMutableEntity{
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

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=20)


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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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