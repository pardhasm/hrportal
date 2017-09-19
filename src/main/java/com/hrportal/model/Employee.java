package com.hrportal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Employees database table.
 *
 */
@Entity
@Table(name = "Employees")
//@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String address1;

    @Column(length = 100)
    private String address2;

    private Long approver1;

    private Long approver2;

    private Long approver3;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(length = 150)
    private String city;

    @Temporal(TemporalType.DATE)
    @Column(name = "confirmation_date")
    private Date confirmationDate;

    @Column(length = 250)
    private String custom1;

    @Column(length = 250)
    private String custom10;

    @Column(length = 250)
    private String custom2;

    @Column(length = 250)
    private String custom3;

    @Column(length = 250)
    private String custom4;

    @Column(length = 250)
    private String custom5;

    @Column(length = 250)
    private String custom6;

    @Column(length = 250)
    private String custom7;

    @Column(length = 250)
    private String custom8;

    @Column(length = 250)
    private String custom9;

    @Column(name = "driving_license", length = 100)
    private String drivingLicense;

    @Temporal(TemporalType.DATE)
    @Column(name = "driving_license_exp_date")
    private Date drivingLicenseExpDate;

    @Column(name = "employee_id", length = 50)
    private String employeeId;

    private Long ethnicity;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "home_phone", length = 50)
    private String homePhone;

    @Column(name = "immigration_status")
    private Long immigrationStatus;

    @Column(name = "indirect_supervisors", length = 250)
    private String indirectSupervisors;

    @Temporal(TemporalType.DATE)
    @Column(name = "joined_date")
    private Date joinedDate;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "marital_status", length = 20)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "mobile_phone", length = 50)
    private String mobilePhone;

    @Column(name = "nic_num", length = 100)
    private String nicNum;

    @Lob
    private String notes;

    @Column(name = "other_id", length = 100)
    private String otherId;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(name = "private_email", length = 100)
    private String privateEmail;

    @Column(name = "ssn_num", length = 100)
    private String ssnNum;


    @Temporal(TemporalType.DATE)
    @Column(name = "termination_date")
    private Date terminationDate;

    @Column(name = "work_email", length = 100)
    private String workEmail;

    @Column(name = "work_phone", length = 50)
    private String workPhone;

    @Column(name = "work_station_id", length = 100)
    private String workStationId;

    //bi-directional many-to-one association to Attendance
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<Attendance> attendances;

    //bi-directional many-to-one association to Cours
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Set<Course> courses;

    //bi-directional many-to-one association to EmergencyContact
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmergencyContact> emergencyContacts;

    //bi-directional many-to-one association to EmployeeAttendanceSheet
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeAttendanceSheet> employeeAttendanceSheets;

    //bi-directional many-to-one association to EmployeeCertification
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeCertification> employeeCertifications;

    //bi-directional many-to-one association to EmployeeCompanyLoan
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeCompanyLoan> employeeCompanyLoans;

    //bi-directional many-to-one association to EmployeeDataHistory
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeDataHistory> employeeDataHistories;

    //bi-directional many-to-one association to EmployeeDependent
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeDependent> employeeDependents;

    //bi-directional many-to-one association to EmployeeDocument
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeDocument> employeeDocuments;

    //bi-directional many-to-one association to EmployeeEducation
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeEducation> employeeEducations;

    //bi-directional many-to-one association to EmployeeEthnicity
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeEthnicity> employeeEthnicities;

    //bi-directional many-to-one association to EmployeeExpens
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeExpense> employeeExpenses;

    //bi-directional many-to-one association to EmployeeForm
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeForm> employeeForms;

    //bi-directional many-to-one association to EmployeeImmigrationStatus
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeImmigrationStatus> employeeImmigrationStatuses;

    //bi-directional many-to-one association to EmployeeImmigration
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeImmigration> employeeImmigrations;

    //bi-directional many-to-one association to EmployeeLanguage
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeLanguage> employeeLanguages;

    //bi-directional many-to-one association to EmployeeLeave
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeLeave> employeeLeaves;

    //bi-directional many-to-one association to EmployeeOvertime
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeOvertime> employeeOvertimes;

    //bi-directional many-to-one association to EmployeeProject
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeProject> employeeProjects;

    //bi-directional many-to-one association to EmployeeSalary
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeSalary> employeeSalaries;

    //bi-directional many-to-one association to EmployeeSkill
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeSkill> employeeSkills;

    //bi-directional many-to-one association to EmployeeTimeEntry
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeTimeEntry> employeeTimeEntries;

    //bi-directional many-to-one association to EmployeeTimeSheet
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeTimeSheet> employeeTimeSheets;

    //bi-directional many-to-one association to EmployeeTrainingSession
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeTrainingSession> employeeTrainingSessions;

    //bi-directional many-to-one association to EmployeeTravelRecord
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<EmployeeTravelRecord> employeeTravelRecords;

    //bi-directional many-to-one association to CompanyStructure
    @ManyToOne
    @JoinColumn(name = "department")
    private CompanyStructure companyStructure;

    //bi-directional many-to-one association to Country
    @ManyToOne
    @JoinColumn(name = "country")
    private Country countryBean;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name = "supervisor")
    private Employee employee;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    //bi-directional many-to-one association to EmploymentStatus
    @ManyToOne
    @JoinColumn(name = "employment_status")
    private EmploymentStatus employmentStatusBean;

    //bi-directional many-to-one association to JobTitle
    @ManyToOne
    @JoinColumn(name = "job_title")
    private JobTitle jobTitleBean;

    //bi-directional many-to-one association to Nationality
    @ManyToOne
    @JoinColumn(name = "nationality")
    private Nationality nationalityBean;

    //bi-directional many-to-one association to PayGrade
    @ManyToOne
    @JoinColumn(name = "pay_grade")
    private PayGrade payGradeBean;

    //bi-directional many-to-one association to Province
    @ManyToOne
    @JoinColumn(name = "province")
    private Province provinceBean;

    //bi-directional many-to-one association to LeaveGroupEmployee
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<LeaveGroupEmployee> leaveGroupEmployees;

    //bi-directional many-to-one association to PayrollEmployee
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<PayrollEmployee> payrollEmployees;

    //bi-directional many-to-one association to User
    @OneToMany(mappedBy = "employeeBean", fetch = FetchType.EAGER)
    private Set<User> users;

    public Employee() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Long getApprover1() {
        return this.approver1;
    }

    public void setApprover1(Long approver1) {
        this.approver1 = approver1;
    }

    public Long getApprover2() {
        return this.approver2;
    }

    public void setApprover2(Long approver2) {
        this.approver2 = approver2;
    }

    public Long getApprover3() {
        return this.approver3;
    }

    public void setApprover3(Long approver3) {
        this.approver3 = approver3;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getConfirmationDate() {
        return this.confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getCustom1() {
        return this.custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom10() {
        return this.custom10;
    }

    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }

    public String getCustom2() {
        return this.custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return this.custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return this.custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return this.custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public String getCustom6() {
        return this.custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public String getCustom7() {
        return this.custom7;
    }

    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }

    public String getCustom8() {
        return this.custom8;
    }

    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }

    public String getCustom9() {
        return this.custom9;
    }

    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }

    public String getDrivingLicense() {
        return this.drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Date getDrivingLicenseExpDate() {
        return this.drivingLicenseExpDate;
    }

    public void setDrivingLicenseExpDate(Date drivingLicenseExpDate) {
        this.drivingLicenseExpDate = drivingLicenseExpDate;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEthnicity() {
        return this.ethnicity;
    }

    public void setEthnicity(Long ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public Long getImmigrationStatus() {
        return this.immigrationStatus;
    }

    public void setImmigrationStatus(Long immigrationStatus) {
        this.immigrationStatus = immigrationStatus;
    }

    public String getIndirectSupervisors() {
        return this.indirectSupervisors;
    }

    public void setIndirectSupervisors(String indirectSupervisors) {
        this.indirectSupervisors = indirectSupervisors;
    }

    public Date getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MaritalStatus getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNicNum() {
        return this.nicNum;
    }

    public void setNicNum(String nicNum) {
        this.nicNum = nicNum;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOtherId() {
        return this.otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPrivateEmail() {
        return this.privateEmail;
    }

    public void setPrivateEmail(String privateEmail) {
        this.privateEmail = privateEmail;
    }

    public String getSsnNum() {
        return this.ssnNum;
    }

    public void setSsnNum(String ssnNum) {
        this.ssnNum = ssnNum;
    }



    public Date getTerminationDate() {
        return this.terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getWorkEmail() {
        return this.workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getWorkPhone() {
        return this.workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkStationId() {
        return this.workStationId;
    }

    public void setWorkStationId(String workStationId) {
        this.workStationId = workStationId;
    }

    public Set<Attendance> getAttendances() {
        return this.attendances;
    }

    public void setAttendances(Set<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Attendance addAttendance(Attendance attendance) {
        getAttendances().add(attendance);
        attendance.setEmployeeBean(this);

        return attendance;
    }

    public Attendance removeAttendance(Attendance attendance) {
        getAttendances().remove(attendance);
        attendance.setEmployeeBean(null);

        return attendance;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Course addCours(Course course) {
        getCourses().add(course);
        course.setEmployee(this);

        return course;
    }

    public Course removeCours(Course course) {
        getCourses().remove(course);
        course.setEmployee(null);

        return course;
    }

    public Set<EmergencyContact> getEmergencyContacts() {
        return this.emergencyContacts;
    }

    public void setEmergencyContacts(Set<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public EmergencyContact addEmergencyContact(EmergencyContact emergencyContact) {
        getEmergencyContacts().add(emergencyContact);
        emergencyContact.setEmployeeBean(this);

        return emergencyContact;
    }

    public EmergencyContact removeEmergencyContact(EmergencyContact emergencyContact) {
        getEmergencyContacts().remove(emergencyContact);
        emergencyContact.setEmployeeBean(null);

        return emergencyContact;
    }

    public Set<EmployeeAttendanceSheet> getEmployeeAttendanceSheets() {
        return this.employeeAttendanceSheets;
    }

    public void setEmployeeAttendanceSheets(Set<EmployeeAttendanceSheet> employeeAttendanceSheets) {
        this.employeeAttendanceSheets = employeeAttendanceSheets;
    }

    public EmployeeAttendanceSheet addEmployeeAttendanceSheet(EmployeeAttendanceSheet employeeAttendanceSheet) {
        getEmployeeAttendanceSheets().add(employeeAttendanceSheet);
        employeeAttendanceSheet.setEmployeeBean(this);

        return employeeAttendanceSheet;
    }

    public EmployeeAttendanceSheet removeEmployeeAttendanceSheet(EmployeeAttendanceSheet employeeAttendanceSheet) {
        getEmployeeAttendanceSheets().remove(employeeAttendanceSheet);
        employeeAttendanceSheet.setEmployeeBean(null);

        return employeeAttendanceSheet;
    }

    public Set<EmployeeCertification> getEmployeeCertifications() {
        return this.employeeCertifications;
    }

    public void setEmployeeCertifications(Set<EmployeeCertification> employeeCertifications) {
        this.employeeCertifications = employeeCertifications;
    }

    public EmployeeCertification addEmployeeCertification(EmployeeCertification employeeCertification) {
        getEmployeeCertifications().add(employeeCertification);
        employeeCertification.setEmployeeBean(this);

        return employeeCertification;
    }

    public EmployeeCertification removeEmployeeCertification(EmployeeCertification employeeCertification) {
        getEmployeeCertifications().remove(employeeCertification);
        employeeCertification.setEmployeeBean(null);

        return employeeCertification;
    }

    public Set<EmployeeCompanyLoan> getEmployeeCompanyLoans() {
        return this.employeeCompanyLoans;
    }

    public void setEmployeeCompanyLoans(Set<EmployeeCompanyLoan> employeeCompanyLoans) {
        this.employeeCompanyLoans = employeeCompanyLoans;
    }

    public EmployeeCompanyLoan addEmployeeCompanyLoan(EmployeeCompanyLoan employeeCompanyLoan) {
        getEmployeeCompanyLoans().add(employeeCompanyLoan);
        employeeCompanyLoan.setEmployeeBean(this);

        return employeeCompanyLoan;
    }

    public EmployeeCompanyLoan removeEmployeeCompanyLoan(EmployeeCompanyLoan employeeCompanyLoan) {
        getEmployeeCompanyLoans().remove(employeeCompanyLoan);
        employeeCompanyLoan.setEmployeeBean(null);

        return employeeCompanyLoan;
    }

    public Set<EmployeeDataHistory> getEmployeeDataHistories() {
        return this.employeeDataHistories;
    }

    public void setEmployeeDataHistories(Set<EmployeeDataHistory> employeeDataHistories) {
        this.employeeDataHistories = employeeDataHistories;
    }

    public EmployeeDataHistory addEmployeeDataHistory(EmployeeDataHistory employeeDataHistory) {
        getEmployeeDataHistories().add(employeeDataHistory);
        employeeDataHistory.setEmployeeBean(this);

        return employeeDataHistory;
    }

    public EmployeeDataHistory removeEmployeeDataHistory(EmployeeDataHistory employeeDataHistory) {
        getEmployeeDataHistories().remove(employeeDataHistory);
        employeeDataHistory.setEmployeeBean(null);

        return employeeDataHistory;
    }

    public Set<EmployeeDependent> getEmployeeDependents() {
        return this.employeeDependents;
    }

    public void setEmployeeDependents(Set<EmployeeDependent> employeeDependents) {
        this.employeeDependents = employeeDependents;
    }

    public EmployeeDependent addEmployeeDependent(EmployeeDependent employeeDependent) {
        getEmployeeDependents().add(employeeDependent);
        employeeDependent.setEmployeeBean(this);

        return employeeDependent;
    }

    public EmployeeDependent removeEmployeeDependent(EmployeeDependent employeeDependent) {
        getEmployeeDependents().remove(employeeDependent);
        employeeDependent.setEmployeeBean(null);

        return employeeDependent;
    }

    public Set<EmployeeDocument> getEmployeeDocuments() {
        return this.employeeDocuments;
    }

    public void setEmployeeDocuments(Set<EmployeeDocument> employeeDocuments) {
        this.employeeDocuments = employeeDocuments;
    }

    public EmployeeDocument addEmployeeDocument(EmployeeDocument employeeDocument) {
        getEmployeeDocuments().add(employeeDocument);
        employeeDocument.setEmployeeBean(this);

        return employeeDocument;
    }

    public EmployeeDocument removeEmployeeDocument(EmployeeDocument employeeDocument) {
        getEmployeeDocuments().remove(employeeDocument);
        employeeDocument.setEmployeeBean(null);

        return employeeDocument;
    }

    public Set<EmployeeEducation> getEmployeeEducations() {
        return this.employeeEducations;
    }

    public void setEmployeeEducations(Set<EmployeeEducation> employeeEducations) {
        this.employeeEducations = employeeEducations;
    }

    public EmployeeEducation addEmployeeEducation(EmployeeEducation employeeEducation) {
        getEmployeeEducations().add(employeeEducation);
        employeeEducation.setEmployeeBean(this);

        return employeeEducation;
    }

    public EmployeeEducation removeEmployeeEducation(EmployeeEducation employeeEducation) {
        getEmployeeEducations().remove(employeeEducation);
        employeeEducation.setEmployeeBean(null);

        return employeeEducation;
    }

    public Set<EmployeeEthnicity> getEmployeeEthnicities() {
        return this.employeeEthnicities;
    }

    public void setEmployeeEthnicities(Set<EmployeeEthnicity> employeeEthnicities) {
        this.employeeEthnicities = employeeEthnicities;
    }

    public EmployeeEthnicity addEmployeeEthnicity(EmployeeEthnicity employeeEthnicity) {
        getEmployeeEthnicities().add(employeeEthnicity);
        employeeEthnicity.setEmployeeBean(this);

        return employeeEthnicity;
    }

    public EmployeeEthnicity removeEmployeeEthnicity(EmployeeEthnicity employeeEthnicity) {
        getEmployeeEthnicities().remove(employeeEthnicity);
        employeeEthnicity.setEmployeeBean(null);

        return employeeEthnicity;
    }

    public Set<EmployeeExpense> getEmployeeExpenses() {
        return this.employeeExpenses;
    }

    public void setEmployeeExpenses(Set<EmployeeExpense> employeeExpenses) {
        this.employeeExpenses = employeeExpenses;
    }

    public EmployeeExpense addEmployeeExpens(EmployeeExpense employeeExpense) {
        getEmployeeExpenses().add(employeeExpense);
        employeeExpense.setEmployeeBean(this);

        return employeeExpense;
    }

    public EmployeeExpense removeEmployeeExpens(EmployeeExpense employeeExpense) {
        getEmployeeExpenses().remove(employeeExpense);
        employeeExpense.setEmployeeBean(null);

        return employeeExpense;
    }

    public Set<EmployeeForm> getEmployeeForms() {
        return this.employeeForms;
    }

    public void setEmployeeForms(Set<EmployeeForm> employeeForms) {
        this.employeeForms = employeeForms;
    }

    public EmployeeForm addEmployeeForm(EmployeeForm employeeForm) {
        getEmployeeForms().add(employeeForm);
        employeeForm.setEmployeeBean(this);

        return employeeForm;
    }

    public EmployeeForm removeEmployeeForm(EmployeeForm employeeForm) {
        getEmployeeForms().remove(employeeForm);
        employeeForm.setEmployeeBean(null);

        return employeeForm;
    }

    public Set<EmployeeImmigrationStatus> getEmployeeImmigrationStatuses() {
        return this.employeeImmigrationStatuses;
    }

    public void setEmployeeImmigrationStatuses(Set<EmployeeImmigrationStatus> employeeImmigrationStatuses) {
        this.employeeImmigrationStatuses = employeeImmigrationStatuses;
    }

    public EmployeeImmigrationStatus addEmployeeImmigrationStatus(EmployeeImmigrationStatus employeeImmigrationStatus) {
        getEmployeeImmigrationStatuses().add(employeeImmigrationStatus);
        employeeImmigrationStatus.setEmployeeBean(this);

        return employeeImmigrationStatus;
    }

    public EmployeeImmigrationStatus removeEmployeeImmigrationStatus(EmployeeImmigrationStatus employeeImmigrationStatus) {
        getEmployeeImmigrationStatuses().remove(employeeImmigrationStatus);
        employeeImmigrationStatus.setEmployeeBean(null);

        return employeeImmigrationStatus;
    }

    public Set<EmployeeImmigration> getEmployeeImmigrations() {
        return this.employeeImmigrations;
    }

    public void setEmployeeImmigrations(Set<EmployeeImmigration> employeeImmigrations) {
        this.employeeImmigrations = employeeImmigrations;
    }

    public EmployeeImmigration addEmployeeImmigration(EmployeeImmigration employeeImmigration) {
        getEmployeeImmigrations().add(employeeImmigration);
        employeeImmigration.setEmployeeBean(this);

        return employeeImmigration;
    }

    public EmployeeImmigration removeEmployeeImmigration(EmployeeImmigration employeeImmigration) {
        getEmployeeImmigrations().remove(employeeImmigration);
        employeeImmigration.setEmployeeBean(null);

        return employeeImmigration;
    }

    public Set<EmployeeLanguage> getEmployeeLanguages() {
        return this.employeeLanguages;
    }

    public void setEmployeeLanguages(Set<EmployeeLanguage> employeeLanguages) {
        this.employeeLanguages = employeeLanguages;
    }

    public EmployeeLanguage addEmployeeLanguage(EmployeeLanguage employeeLanguage) {
        getEmployeeLanguages().add(employeeLanguage);
        employeeLanguage.setEmployeeBean(this);

        return employeeLanguage;
    }

    public EmployeeLanguage removeEmployeeLanguage(EmployeeLanguage employeeLanguage) {
        getEmployeeLanguages().remove(employeeLanguage);
        employeeLanguage.setEmployeeBean(null);

        return employeeLanguage;
    }

    public Set<EmployeeLeave> getEmployeeLeaves() {
        return this.employeeLeaves;
    }

    public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
        this.employeeLeaves = employeeLeaves;
    }

    public EmployeeLeave addEmployeeLeave(EmployeeLeave employeeLeave) {
        getEmployeeLeaves().add(employeeLeave);
        employeeLeave.setEmployeeBean(this);

        return employeeLeave;
    }

    public EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeave) {
        getEmployeeLeaves().remove(employeeLeave);
        employeeLeave.setEmployeeBean(null);

        return employeeLeave;
    }

    public Set<EmployeeOvertime> getEmployeeOvertimes() {
        return this.employeeOvertimes;
    }

    public void setEmployeeOvertimes(Set<EmployeeOvertime> employeeOvertimes) {
        this.employeeOvertimes = employeeOvertimes;
    }

    public EmployeeOvertime addEmployeeOvertime(EmployeeOvertime employeeOvertime) {
        getEmployeeOvertimes().add(employeeOvertime);
        employeeOvertime.setEmployeeBean(this);

        return employeeOvertime;
    }

    public EmployeeOvertime removeEmployeeOvertime(EmployeeOvertime employeeOvertime) {
        getEmployeeOvertimes().remove(employeeOvertime);
        employeeOvertime.setEmployeeBean(null);

        return employeeOvertime;
    }

    public Set<EmployeeProject> getEmployeeProjects() {
        return this.employeeProjects;
    }

    public void setEmployeeProjects(Set<EmployeeProject> employeeProjects) {
        this.employeeProjects = employeeProjects;
    }

    public EmployeeProject addEmployeeProject(EmployeeProject employeeProject) {
        getEmployeeProjects().add(employeeProject);
        employeeProject.setEmployeeBean(this);

        return employeeProject;
    }

    public EmployeeProject removeEmployeeProject(EmployeeProject employeeProject) {
        getEmployeeProjects().remove(employeeProject);
        employeeProject.setEmployeeBean(null);

        return employeeProject;
    }

    public Set<EmployeeSalary> getEmployeeSalaries() {
        return this.employeeSalaries;
    }

    public void setEmployeeSalaries(Set<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

    public EmployeeSalary addEmployeeSalary(EmployeeSalary employeeSalary) {
        getEmployeeSalaries().add(employeeSalary);
        employeeSalary.setEmployeeBean(this);

        return employeeSalary;
    }

    public EmployeeSalary removeEmployeeSalary(EmployeeSalary employeeSalary) {
        getEmployeeSalaries().remove(employeeSalary);
        employeeSalary.setEmployeeBean(null);

        return employeeSalary;
    }

    public Set<EmployeeSkill> getEmployeeSkills() {
        return this.employeeSkills;
    }

    public void setEmployeeSkills(Set<EmployeeSkill> employeeSkills) {
        this.employeeSkills = employeeSkills;
    }

    public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
        getEmployeeSkills().add(employeeSkill);
        employeeSkill.setEmployeeBean(this);

        return employeeSkill;
    }

    public EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkill) {
        getEmployeeSkills().remove(employeeSkill);
        employeeSkill.setEmployeeBean(null);

        return employeeSkill;
    }

    public Set<EmployeeTimeEntry> getEmployeeTimeEntries() {
        return this.employeeTimeEntries;
    }

    public void setEmployeeTimeEntries(Set<EmployeeTimeEntry> employeeTimeEntries) {
        this.employeeTimeEntries = employeeTimeEntries;
    }

    public EmployeeTimeEntry addEmployeeTimeEntry(EmployeeTimeEntry employeeTimeEntry) {
        getEmployeeTimeEntries().add(employeeTimeEntry);
        employeeTimeEntry.setEmployeeBean(this);

        return employeeTimeEntry;
    }

    public EmployeeTimeEntry removeEmployeeTimeEntry(EmployeeTimeEntry employeeTimeEntry) {
        getEmployeeTimeEntries().remove(employeeTimeEntry);
        employeeTimeEntry.setEmployeeBean(null);

        return employeeTimeEntry;
    }

    public Set<EmployeeTimeSheet> getEmployeeTimeSheets() {
        return this.employeeTimeSheets;
    }

    public void setEmployeeTimeSheets(Set<EmployeeTimeSheet> employeeTimeSheets) {
        this.employeeTimeSheets = employeeTimeSheets;
    }

    public EmployeeTimeSheet addEmployeeTimeSheet(EmployeeTimeSheet employeeTimeSheet) {
        getEmployeeTimeSheets().add(employeeTimeSheet);
        employeeTimeSheet.setEmployeeBean(this);

        return employeeTimeSheet;
    }

    public EmployeeTimeSheet removeEmployeeTimeSheet(EmployeeTimeSheet employeeTimeSheet) {
        getEmployeeTimeSheets().remove(employeeTimeSheet);
        employeeTimeSheet.setEmployeeBean(null);

        return employeeTimeSheet;
    }

    public Set<EmployeeTrainingSession> getEmployeeTrainingSessions() {
        return this.employeeTrainingSessions;
    }

    public void setEmployeeTrainingSessions(Set<EmployeeTrainingSession> employeeTrainingSessions) {
        this.employeeTrainingSessions = employeeTrainingSessions;
    }

    public EmployeeTrainingSession addEmployeeTrainingSession(EmployeeTrainingSession employeeTrainingSession) {
        getEmployeeTrainingSessions().add(employeeTrainingSession);
        employeeTrainingSession.setEmployeeBean(this);

        return employeeTrainingSession;
    }

    public EmployeeTrainingSession removeEmployeeTrainingSession(EmployeeTrainingSession employeeTrainingSession) {
        getEmployeeTrainingSessions().remove(employeeTrainingSession);
        employeeTrainingSession.setEmployeeBean(null);

        return employeeTrainingSession;
    }

    public Set<EmployeeTravelRecord> getEmployeeTravelRecords() {
        return this.employeeTravelRecords;
    }

    public void setEmployeeTravelRecords(Set<EmployeeTravelRecord> employeeTravelRecords) {
        this.employeeTravelRecords = employeeTravelRecords;
    }

    public EmployeeTravelRecord addEmployeeTravelRecord(EmployeeTravelRecord employeeTravelRecord) {
        getEmployeeTravelRecords().add(employeeTravelRecord);
        employeeTravelRecord.setEmployeeBean(this);

        return employeeTravelRecord;
    }

    public EmployeeTravelRecord removeEmployeeTravelRecord(EmployeeTravelRecord employeeTravelRecord) {
        getEmployeeTravelRecords().remove(employeeTravelRecord);
        employeeTravelRecord.setEmployeeBean(null);

        return employeeTravelRecord;
    }

    public CompanyStructure getCompanyStructure() {
        return this.companyStructure;
    }

    public void setCompanyStructure(CompanyStructure companyStructure) {
        this.companyStructure = companyStructure;
    }

    public Country getCountryBean() {
        return this.countryBean;
    }

    public void setCountryBean(Country countryBean) {
        this.countryBean = countryBean;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setEmployee(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setEmployee(null);

        return employee;
    }

    public EmploymentStatus getEmploymentStatusBean() {
        return this.employmentStatusBean;
    }

    public void setEmploymentStatusBean(EmploymentStatus employmentStatusBean) {
        this.employmentStatusBean = employmentStatusBean;
    }

    public JobTitle getJobTitleBean() {
        return this.jobTitleBean;
    }

    public void setJobTitleBean(JobTitle jobTitleBean) {
        this.jobTitleBean = jobTitleBean;
    }

    public Nationality getNationalityBean() {
        return this.nationalityBean;
    }

    public void setNationalityBean(Nationality nationalityBean) {
        this.nationalityBean = nationalityBean;
    }

    public PayGrade getPayGradeBean() {
        return this.payGradeBean;
    }

    public void setPayGradeBean(PayGrade payGradeBean) {
        this.payGradeBean = payGradeBean;
    }

    public Province getProvinceBean() {
        return this.provinceBean;
    }

    public void setProvinceBean(Province provinceBean) {
        this.provinceBean = provinceBean;
    }

    public Set<LeaveGroupEmployee> getLeaveGroupEmployees() {
        return this.leaveGroupEmployees;
    }

    public void setLeaveGroupEmployees(Set<LeaveGroupEmployee> leaveGroupEmployees) {
        this.leaveGroupEmployees = leaveGroupEmployees;
    }

    public LeaveGroupEmployee addLeaveGroupEmployee(LeaveGroupEmployee leaveGroupEmployee) {
        getLeaveGroupEmployees().add(leaveGroupEmployee);
        leaveGroupEmployee.setEmployeeBean(this);

        return leaveGroupEmployee;
    }

    public LeaveGroupEmployee removeLeaveGroupEmployee(LeaveGroupEmployee leaveGroupEmployee) {
        getLeaveGroupEmployees().remove(leaveGroupEmployee);
        leaveGroupEmployee.setEmployeeBean(null);

        return leaveGroupEmployee;
    }

    public Set<PayrollEmployee> getPayrollEmployees() {
        return this.payrollEmployees;
    }

    public void setPayrollEmployees(Set<PayrollEmployee> payrollEmployees) {
        this.payrollEmployees = payrollEmployees;
    }

    public PayrollEmployee addPayrollEmployee(PayrollEmployee payrollEmployee) {
        getPayrollEmployees().add(payrollEmployee);
        payrollEmployee.setEmployeeBean(this);

        return payrollEmployee;
    }

    public PayrollEmployee removePayrollEmployee(PayrollEmployee payrollEmployee) {
        getPayrollEmployees().remove(payrollEmployee);
        payrollEmployee.setEmployeeBean(null);

        return payrollEmployee;
    }

    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User addUser(User user) {
        getUsers().add(user);
        user.setEmployeeBean(this);

        return user;
    }

    public User removeUser(User user) {
        getUsers().remove(user);
        user.setEmployeeBean(null);

        return user;
    }

}