package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the EmployeeImmigrationStatus database table.
 */
@Entity
@Table(name = "EmployeeImmigrationStatus")
//@NamedQuery(name="EmployeeImmigrationStatus.findAll", query="SELECT e FROM EmployeeImmigrationStatus e")
public class EmployeeImmigrationStatus extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    //bi-directional many-to-one association to ImmigrationStatus
    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private ImmigrationStatus immigrationStatus;

    public EmployeeImmigrationStatus() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployeeBean() {
        return this.employeeBean;
    }

    public void setEmployeeBean(Employee employeeBean) {
        this.employeeBean = employeeBean;
    }

    public ImmigrationStatus getImmigrationStatus() {
        return this.immigrationStatus;
    }

    public void setImmigrationStatus(ImmigrationStatus immigrationStatus) {
        this.immigrationStatus = immigrationStatus;
    }

}