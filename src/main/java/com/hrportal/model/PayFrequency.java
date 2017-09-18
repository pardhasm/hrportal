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
public class PayFrequency implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false, length = 200)
    private String name;

    public PayFrequency() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}