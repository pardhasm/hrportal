package com.hrportal.model;

import javax.persistence.*;


/**
 * The persistent class for the Modules database table.
 * 
 */
@Entity
@Table(name="Modules")
//@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=50)
	private String icon;

	@Column(nullable=false, length=100)
	private String label;

	@Column(nullable=false, length=30)
	private String menu;

	@Column(name="mod_group", nullable=false, length=30)
	private String modGroup;

	@Column(name="mod_order")
	private int modOrder;

	@Column(nullable=false, length=100)
	private String name;


	@Column(name="update_path", length=500)
	private String updatePath;

	@Column(name="user_levels", nullable=false, length=500)
	private String userLevels;

	@Lob
	@Column(name="user_roles")
	private String userRoles;

	@Column(length=10)
	private String version;

	public Module() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getModGroup() {
		return this.modGroup;
	}

	public void setModGroup(String modGroup) {
		this.modGroup = modGroup;
	}

	public int getModOrder() {
		return this.modOrder;
	}

	public void setModOrder(int modOrder) {
		this.modOrder = modOrder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getUpdatePath() {
		return this.updatePath;
	}

	public void setUpdatePath(String updatePath) {
		this.updatePath = updatePath;
	}

	public String getUserLevels() {
		return this.userLevels;
	}

	public void setUserLevels(String userLevels) {
		this.userLevels = userLevels;
	}

	public String getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}