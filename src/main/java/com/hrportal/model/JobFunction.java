package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the JobFunction database table.
 * 
 */
@Entity
@Table(name = "JobFunction")
//@NamedQuery(name="JobFunction.findAll", query="SELECT j FROM JobFunction j")
public class JobFunction extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 250)
    @NotNull
    private String name;

    public JobFunction() {
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