package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the SupportedLanguages database table.
 *
 */
@Entity
@Table(name = "SupportedLanguages")
//@NamedQuery(name="SupportedLanguage.findAll", query="SELECT s FROM SupportedLanguage s")
public class SupportedLanguage extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String description;

    @Column(length = 100)
    private String name;

    //bi-directional many-to-one association to User
    @OneToMany(mappedBy = "supportedLanguage", fetch = FetchType.EAGER)
    private Set<User> users;

    public SupportedLanguage() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User addUser(User user) {
        getUsers().add(user);
        user.setSupportedLanguage(this);

        return user;
    }

    public User removeUser(User user) {
        getUsers().remove(user);
        user.setSupportedLanguage(null);

        return user;
    }

}