package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the Country database table.
 *
 */
@Entity
@Table(name = "Country")
//@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 2)
    private String code;

    @Column(length = 3)
    private String iso3;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(length = 80)
    private String namecap;

    private short numcode;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "countryBean", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    //bi-directional many-to-one association to Province
    @OneToMany(mappedBy = "countryBean", fetch = FetchType.EAGER)
    private Set<Province> provinces;

    public Country() {
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

    public String getIso3() {
        return this.iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamecap() {
        return this.namecap;
    }

    public void setNamecap(String namecap) {
        this.namecap = namecap;
    }

    public short getNumcode() {
        return this.numcode;
    }

    public void setNumcode(short numcode) {
        this.numcode = numcode;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setCountryBean(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setCountryBean(null);

        return employee;
    }

    public Set<Province> getProvinces() {
        return this.provinces;
    }

    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }

    public Province addProvince(Province province) {
        getProvinces().add(province);
        province.setCountryBean(this);

        return province;
    }

    public Province removeProvince(Province province) {
        getProvinces().remove(province);
        province.setCountryBean(null);

        return province;
    }

}