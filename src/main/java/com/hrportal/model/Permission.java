package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;



/**
 * The persistent class for the Permissions database table.
 * 
 */
@Entity
@Table(name="Permissions")
//@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=500)
	private String meta;

	@Column(name="module_id", nullable=false)
    private Long moduleId;

	@Column(length=200)
	private String permission;

	@Column(name="user_level", length=20)
	@Enumerated(EnumType.STRING)
	private UserLevel userLevel;

	@Column(length=200)
	private String value;

	public Permission() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeta() {
		return this.meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

    public Long getModuleId() {
        return this.moduleId;
	}

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public UserLevel getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}