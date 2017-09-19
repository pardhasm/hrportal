package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the Educations database table.
 *
 */
@Entity
@Table(name = "Educations")
//@NamedQuery(name="Education.findAll", query="SELECT e FROM Education e")
public class Education extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 400)
    private String description;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to EmployeeEducation
    @OneToMany(mappedBy = "education", fetch = FetchType.EAGER)
    private Set<EmployeeEducation> employeeEducations;

    public Education() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeEducation> getEmployeeEducations() {
        return this.employeeEducations;
    }

    public void setEmployeeEducations(Set<EmployeeEducation> employeeEducations) {
        this.employeeEducations = employeeEducations;
    }

    public EmployeeEducation addEmployeeEducation(EmployeeEducation employeeEducation) {
        getEmployeeEducations().add(employeeEducation);
        employeeEducation.setEducation(this);

        return employeeEducation;
    }

    public EmployeeEducation removeEmployeeEducation(EmployeeEducation employeeEducation) {
        getEmployeeEducations().remove(employeeEducation);
        employeeEducation.setEducation(null);

        return employeeEducation;
    }

}