package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(name="default_module")
    private Long defaultModule;

	@Column(length=100)
	private String email;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="last_login")
    private DateTime lastLogin;

    @org.hibernate.annotations.Type(type = "updatedTime")
    @Column(name="last_update")
    private DateTime lastUpdate;

	@Column(name="login_hash", length=64)
	private String loginHash;

	@Column(length=100)
	private String password;

	@Column(name="user_level", length=20)
	@Enumerated(EnumType.STRING)
	private UserLevel userLevel;

	@Lob
	@Column(name="user_roles")
	private String userRoles;

	@Column(length=100)
	private String username;

	//bi-directional many-to-one association to AuditLog
	@OneToMany(mappedBy="userBean", fetch=FetchType.EAGER)
	private Set<AuditLog> auditLogs;

	//bi-directional many-to-one association to EmployeeDataHistory
	@OneToMany(mappedBy="userBean", fetch=FetchType.EAGER)
	private Set<EmployeeDataHistory> employeeDataHistories;

	//bi-directional many-to-one association to EmployeeLeaveLog
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<EmployeeLeaveLog> employeeLeaveLogs;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private Set<Notification> notifications;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee")
	private Employee employeeBean;

	//bi-directional many-to-one association to SupportedLanguage
	@ManyToOne
	@JoinColumn(name="lang")
	private SupportedLanguage supportedLanguage;

	public User() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
        this.created = created;
	}

    public Long getDefaultModule() {
        return this.defaultModule;
	}

    public void setDefaultModule(Long defaultModule) {
        this.defaultModule = defaultModule;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public DateTime getLastLogin() {
        return this.lastLogin;
	}

    public void setLastLogin(DateTime lastLogin) {
        this.lastLogin = lastLogin;
	}

    public DateTime getLastUpdate() {
        return this.lastUpdate;
	}

    public void setLastUpdate(DateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
	}

	public String getLoginHash() {
		return this.loginHash;
	}

	public void setLoginHash(String loginHash) {
		this.loginHash = loginHash;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLevel getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<AuditLog> getAuditLogs() {
		return this.auditLogs;
	}

	public void setAuditLogs(Set<AuditLog> auditLogs) {
		this.auditLogs = auditLogs;
	}

	public AuditLog addAuditLog(AuditLog auditLog) {
		getAuditLogs().add(auditLog);
		auditLog.setUserBean(this);

		return auditLog;
	}

	public AuditLog removeAuditLog(AuditLog auditLog) {
		getAuditLogs().remove(auditLog);
		auditLog.setUserBean(null);

		return auditLog;
	}

	public Set<EmployeeDataHistory> getEmployeeDataHistories() {
		return this.employeeDataHistories;
	}

	public void setEmployeeDataHistories(Set<EmployeeDataHistory> employeeDataHistories) {
		this.employeeDataHistories = employeeDataHistories;
	}

	public EmployeeDataHistory addEmployeeDataHistory(EmployeeDataHistory employeeDataHistory) {
		getEmployeeDataHistories().add(employeeDataHistory);
		employeeDataHistory.setUserBean(this);

		return employeeDataHistory;
	}

	public EmployeeDataHistory removeEmployeeDataHistory(EmployeeDataHistory employeeDataHistory) {
		getEmployeeDataHistories().remove(employeeDataHistory);
		employeeDataHistory.setUserBean(null);

		return employeeDataHistory;
	}

	public Set<EmployeeLeaveLog> getEmployeeLeaveLogs() {
		return this.employeeLeaveLogs;
	}

	public void setEmployeeLeaveLogs(Set<EmployeeLeaveLog> employeeLeaveLogs) {
		this.employeeLeaveLogs = employeeLeaveLogs;
	}

	public EmployeeLeaveLog addEmployeeLeaveLog(EmployeeLeaveLog employeeLeaveLog) {
		getEmployeeLeaveLogs().add(employeeLeaveLog);
		employeeLeaveLog.setUser(this);

		return employeeLeaveLog;
	}

	public EmployeeLeaveLog removeEmployeeLeaveLog(EmployeeLeaveLog employeeLeaveLog) {
		getEmployeeLeaveLogs().remove(employeeLeaveLog);
		employeeLeaveLog.setUser(null);

		return employeeLeaveLog;
	}

	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setUser(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setUser(null);

		return notification;
	}

	public Employee getEmployeeBean() {
		return this.employeeBean;
	}

	public void setEmployeeBean(Employee employeeBean) {
		this.employeeBean = employeeBean;
	}

	public SupportedLanguage getSupportedLanguage() {
		return this.supportedLanguage;
	}

	public void setSupportedLanguage(SupportedLanguage supportedLanguage) {
		this.supportedLanguage = supportedLanguage;
	}

}