package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Entity
@Table(name = "PayGrades")
public class PayGrade extends AbstractMutableEntity {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Length(max = 100)
    private String name;
    @Length(max = 3)
    @OneToOne               //TODO
    @JoinColumn(table = "CurrencyTypes", referencedColumnName = "code")
    private CurrencyType currency;
    @Column(name = "min_salary")
    private Double minSalary;   //TODO
    @Column(name = "max_salary")
    private Double maxSalary;

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

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "PayGrade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }
}
