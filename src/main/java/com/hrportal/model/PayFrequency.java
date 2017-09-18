package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */

@Entity
@Table(name = "PayFrequency")
public class PayFrequency extends AbstractMutableEntity {

    @Id
    @Length(max = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 200)
    @NotNull
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

    @Override
    public String toString() {
        return "PayFrequency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}