package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Entity
@Table(name = "Certifications")
public class Certification extends AbstractMutableEntity {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 100)
    private String name;
    @Length(max = 400)
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
