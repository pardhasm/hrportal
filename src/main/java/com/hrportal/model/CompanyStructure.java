package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Lalith leela vishnu on 18-09-2017.
 */
@Entity
@Table(name = "CompanyStructures")
public class CompanyStructure extends AbstractMutableEntity {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String title;
    @Column
    @NotNull
    private String description;
    @Column
    private String address;
    @Column
    private Type type;
    @Column
    @NotNull
    @Length(max = 2)
    private String country;
    @OneToOne           //TODO
    @JoinColumn(table = "CompanyStructures", referencedColumnName = "id")
    private CompanyStructure parent;
    @Column(name = "timezone")
    @NotNull
    private String timeZone;
    @Column
    private String heads;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CompanyStructure getParent() {
        return parent;
    }

    public void setParent(CompanyStructure parent) {
        this.parent = parent;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getHeads() {
        return heads;
    }

    public void setHeads(String heads) {
        this.heads = heads;
    }

    @Override
    public String toString() {
        return "CompanyStructure{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", country='" + country + '\'' +
                ", parent=" + parent +
                ", timeZone='" + timeZone + '\'' +
                ", heads='" + heads + '\'' +
                '}';
    }
}
