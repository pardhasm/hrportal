package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the EmployeeEthnicity database table.
 */
@Entity
@Table(name = "EmployeeEthnicity")
//@NamedQuery(name="EmployeeEthnicity.findAll", query="SELECT e FROM EmployeeEthnicity e")
public class EmployeeEthnicity extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employeeBean;

    //bi-directional many-to-one association to Ethnicity
    @ManyToOne
    @JoinColumn(name = "ethnicity", nullable = false)
    private Ethnicity ethnicityBean;

    public EmployeeEthnicity() {
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

    public Ethnicity getEthnicityBean() {
        return this.ethnicityBean;
    }

    public void setEthnicityBean(Ethnicity ethnicityBean) {
        this.ethnicityBean = ethnicityBean;
    }

}