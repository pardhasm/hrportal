package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the ImmigrationStatus database table.
 */
@Entity
@Table(name = "ImmigrationStatus")
//@NamedQuery(name="ImmigrationStatus.findAll", query="SELECT i FROM ImmigrationStatus i")
public class ImmigrationStatus extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    //bi-directional many-to-one association to EmployeeImmigrationStatus
    @OneToMany(mappedBy = "immigrationStatus", fetch = FetchType.EAGER)
    private Set<EmployeeImmigrationStatus> employeeImmigrationStatuses;

    public ImmigrationStatus() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeImmigrationStatus> getEmployeeImmigrationStatuses() {
        return this.employeeImmigrationStatuses;
    }

    public void setEmployeeImmigrationStatuses(Set<EmployeeImmigrationStatus> employeeImmigrationStatuses) {
        this.employeeImmigrationStatuses = employeeImmigrationStatuses;
    }

    public EmployeeImmigrationStatus addEmployeeImmigrationStatus(EmployeeImmigrationStatus employeeImmigrationStatus) {
        getEmployeeImmigrationStatuses().add(employeeImmigrationStatus);
        employeeImmigrationStatus.setImmigrationStatus(this);

        return employeeImmigrationStatus;
    }

    public EmployeeImmigrationStatus removeEmployeeImmigrationStatus(EmployeeImmigrationStatus employeeImmigrationStatus) {
        getEmployeeImmigrationStatuses().remove(employeeImmigrationStatus);
        employeeImmigrationStatus.setImmigrationStatus(null);

        return employeeImmigrationStatus;
    }

}