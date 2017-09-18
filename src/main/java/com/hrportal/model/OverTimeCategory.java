package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Entity
@Table(name = "OvertimeCategories")
public class OverTimeCategory extends AbstractMutableEntity {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 500)
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
        return "OverTimeCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
