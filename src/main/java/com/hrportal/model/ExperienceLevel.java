package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the ExperienceLevel database table.
 * 
 */
@Entity
@Table(name = "ExperienceLevel")
//@NamedQuery(name="ExperienceLevel.findAll", query="SELECT e FROM ExperienceLevel e")
public class ExperienceLevel extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 250)
    private String name;

    public ExperienceLevel() {
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