package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Entity
@Table(name = "Nationality")
public class Nationality extends AbstractMutableEntity {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 100)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
