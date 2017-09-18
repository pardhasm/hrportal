package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the Certifications database table.
 *
 */
@Entity
@Table(name = "Certifications")
//@NamedQuery(name="Certification.findAll", query="SELECT c FROM Certification c")
public class Certification implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 400)
    private String description;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to EmployeeCertification
    @OneToMany(mappedBy = "certification", fetch = FetchType.EAGER)
    private Set<EmployeeCertification> employeeCertifications;

    public Certification() {
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

    public Set<EmployeeCertification> getEmployeeCertifications() {
        return this.employeeCertifications;
    }

    public void setEmployeeCertifications(Set<EmployeeCertification> employeeCertifications) {
        this.employeeCertifications = employeeCertifications;
    }

    public EmployeeCertification addEmployeeCertification(EmployeeCertification employeeCertification) {
        getEmployeeCertifications().add(employeeCertification);
        employeeCertification.setCertification(this);

        return employeeCertification;
    }

    public EmployeeCertification removeEmployeeCertification(EmployeeCertification employeeCertification) {
        getEmployeeCertifications().remove(employeeCertification);
        employeeCertification.setCertification(null);

        return employeeCertification;
    }

}