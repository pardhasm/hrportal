package com.hrportal.model;

import javax.persistence.*;


/**
 * The persistent class for the EmployementType database table.
 * 
 */
@Entity
@Table(name = "EmployementType")
//@NamedQuery(name="EmployementType.findAll", query="SELECT e FROM EmployementType e")
public class EmployementType extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 250)
    private String name;

    public EmployementType() {
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

}