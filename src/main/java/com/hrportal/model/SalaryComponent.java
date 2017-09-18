package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the SalaryComponent database table.
 */
@Entity
@Table(name = "SalaryComponent")
//@NamedQuery(name="SalaryComponent.findAll", query="SELECT s FROM SalaryComponent s")
public class SalaryComponent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Lob
    private String details;

    @Column(nullable = false, length = 100)
    private String name;

    //bi-directional many-to-one association to SalaryComponentType
    @ManyToOne
    @JoinColumn(name = "componentType")
    private SalaryComponentType salaryComponentType;

    public SalaryComponent() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalaryComponentType getSalaryComponentType() {
        return this.salaryComponentType;
    }

    public void setSalaryComponentType(SalaryComponentType salaryComponentType) {
        this.salaryComponentType = salaryComponentType;
    }

}