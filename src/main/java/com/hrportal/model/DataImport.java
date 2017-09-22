package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the DataImport database table.
 */
@Entity
@Table(name = "DataImport")
//@NamedQuery(name="DataImport.findAll", query="SELECT d FROM DataImport d")
public class DataImport extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Lob
    private String columns;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @Column(nullable = false, length = 60)
    @NotNull
    private String dataType;

    @Lob
    private String details;

    @Column(nullable = false, length = 60)
    @NotNull
    private String name;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

    public DataImport() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumns() {
        return this.columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

}