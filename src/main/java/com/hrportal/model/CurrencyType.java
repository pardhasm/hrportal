package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Entity
@Table(name = "CurrencyTypes")
public class CurrencyType extends AbstractMutableEntity {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 3)
    @NotNull
    private String code;
    @Length(max = 70)
    @NotNull
    private String name;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrencyType{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
