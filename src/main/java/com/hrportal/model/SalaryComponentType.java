package com.hrportal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the SalaryComponentType database table.
 */
@Entity
@Table(name = "SalaryComponentType")
//@NamedQuery(name="SalaryComponentType.findAll", query="SELECT s FROM SalaryComponentType s")
public class SalaryComponentType extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 10)
    @NotNull
    private String code;

    @Column(nullable = false, length = 100)
    @NotNull
    private String name;

    //bi-directional many-to-one association to SalaryComponent
    @OneToMany(mappedBy = "salaryComponentType", fetch = FetchType.EAGER)
    private Set<SalaryComponent> salaryComponents;

    public SalaryComponentType() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SalaryComponent> getSalaryComponents() {
        return this.salaryComponents;
    }

    public void setSalaryComponents(Set<SalaryComponent> salaryComponents) {
        this.salaryComponents = salaryComponents;
    }

    public SalaryComponent addSalaryComponent(SalaryComponent salaryComponent) {
        getSalaryComponents().add(salaryComponent);
        salaryComponent.setSalaryComponentType(this);

        return salaryComponent;
    }

    public SalaryComponent removeSalaryComponent(SalaryComponent salaryComponent) {
        getSalaryComponents().remove(salaryComponent);
        salaryComponent.setSalaryComponentType(null);

        return salaryComponent;
    }

}