package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the Skills database table.
 *
 */
@Entity
@Table(name = "Skills")
//@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 400)
    private String description;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to EmployeeSkill
    @OneToMany(mappedBy = "skill", fetch = FetchType.EAGER)
    private Set<EmployeeSkill> employeeSkills;

    public Skill() {
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

    public Set<EmployeeSkill> getEmployeeSkills() {
        return this.employeeSkills;
    }

    public void setEmployeeSkills(Set<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
        getEmployeeSkills().add(employeeSkill);
        employeeSkill.setSkill(this);

        return employeeSkill;
    }

    public EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkill) {
        getEmployeeSkills().remove(employeeSkill);
        employeeSkill.setSkill(null);

        return employeeSkill;
    }

}