package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the Languages database table.
 *
 */
@Entity
@Table(name = "Languages")
//@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 400)
    private String description;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to EmployeeLanguage
    @OneToMany(mappedBy = "language", fetch = FetchType.EAGER)
    private Set<EmployeeLanguage> employeeLanguages;

    public Language() {
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

    public Set<EmployeeLanguage> getEmployeeLanguages() {
        return this.employeeLanguages;
    }

    public void setEmployeeLanguages(Set<EmployeeLanguage> employeeLanguages) {
        this.employeeLanguages = employeeLanguages;
    }

    public EmployeeLanguage addEmployeeLanguage(EmployeeLanguage employeeLanguage) {
        getEmployeeLanguages().add(employeeLanguage);
        employeeLanguage.setLanguage(this);

        return employeeLanguage;
    }

    public EmployeeLanguage removeEmployeeLanguage(EmployeeLanguage employeeLanguage) {
        getEmployeeLanguages().remove(employeeLanguage);
        employeeLanguage.setLanguage(null);

        return employeeLanguage;
    }

}