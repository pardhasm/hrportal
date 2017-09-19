package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the PayFrequency database table.
 * 
 */
@Entity
@Table(name = "PayFrequency")
//@NamedQuery(name="PayFrequency.findAll", query="SELECT p FROM PayFrequency p")
public class PayFrequency extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    public PayFrequency() {
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