package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the Ethnicity database table.
 */
@Entity
@Table(name = "Ethnicity")
//@NamedQuery(name="Ethnicity.findAll", query="SELECT e FROM Ethnicity e")
public class Ethnicity extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull
    private String name;

    //bi-directional many-to-one association to EmployeeEthnicity
    @OneToMany(mappedBy = "ethnicityBean", fetch = FetchType.EAGER)
    private Set<EmployeeEthnicity> employeeEthnicities;

    public Ethnicity() {
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

    public Set<EmployeeEthnicity> getEmployeeEthnicities() {
        return this.employeeEthnicities;
    }

    public void setEmployeeEthnicities(Set<EmployeeEthnicity> employeeEthnicities) {
        this.employeeEthnicities = employeeEthnicities;
    }

    public EmployeeEthnicity addEmployeeEthnicity(EmployeeEthnicity employeeEthnicity) {
        getEmployeeEthnicities().add(employeeEthnicity);
        employeeEthnicity.setEthnicityBean(this);

        return employeeEthnicity;
    }

    public EmployeeEthnicity removeEmployeeEthnicity(EmployeeEthnicity employeeEthnicity) {
        getEmployeeEthnicities().remove(employeeEthnicity);
        employeeEthnicity.setEthnicityBean(null);

        return employeeEthnicity;
    }

}