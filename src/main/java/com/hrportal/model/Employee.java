package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Lalith leela vishnu on 17-09-2017.
 */
@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "employee_id")
    @Length(max = 50)
    private String employeeId;
    @Column(name = "first_name")
    @Length(max = 100)
    @NotNull
    private String firstName;
    @Column(name = "middle_name")
    @Length(max = 100)
    private String middleName;
    @Column(name = "last_name")
    @Length(max = 100)
    private String lastName;
    //TODO
    @ManyToOne
    private Nationality nationality;
    @Column
    private Date birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;
    @Column(name = "ssn_num")
    private String ssnNum;
    @Column(name = "nic_num")
    private String nicNum;
    @Column(name = "other_id")
    private String otherId;
    @Column
    private String driving_license;
    @Column(name = "driving_license_exp_date")
    private Date drivingLicenseExpiryDate;
    @Column(name = "employment_status")
    private Long employmentStatus;
    @ManyToOne(targetEntity = JobTitle
            .class)
    @JoinColumn(referencedColumnName = "id")
    private JobTitle jobTitle;
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private PayGrade payGrade;
    @Column(name = "work_station_id")
    private String workStationId;
    @Column
    private String address1;
    @Column
    private String address2;
    @Column
    private String city;
    @ManyToOne          //TODO
    @JoinColumn(referencedColumnName = "code")
    private Country country;
    @ManyToOne          //TODO
    @JoinColumn(referencedColumnName = "id")
    private Province province;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "home_phone")
    private String homePhone;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "work_phone")
    private String workPhone;
    @Column(name = "work_email")
    private String workEmail;
    @Column(name = "private_email")
    private String privateEmail;
    @Column(name = "joined_date")
    private Date joinedDate;
    @Column(name = "confirmation_date")
    private Date confirmationDate;
    @ManyToOne          //TODO
    @JoinColumn(referencedColumnName = "id")
    private Employee supervisor;
    @Column(name = "indirect_supervisors")
    private String indirectSupervisors;
    @ManyToOne          //TODO
    @JoinColumn(referencedColumnName = "id")
    private CompanyStructure department;
    @Column
    private String custom1;
    @Column
    private String custom2;
    @Column
    private String custom3;
    @Column
    private String custom4;
    @Column
    private String custom5;
    @Column
    private String custom6;
    @Column
    private String custom7;
    @Column
    private String custom8;
    @Column
    private String custom9;
    @Column
    private String custom10;
    @Column(name = "termination_date")
    private Date terminationDate;
    @Column
    private String notes;
    @Column
    private Status status;
    @Column
    private Long ethnicity;
    @Column(name = "immigration_status")
    private Long immigrationStatus;
    @Column
    private Long approver1;
    @Column
    private Long approver2;
    @Column
    private Long approver3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSsnNum() {
        return ssnNum;
    }

    public void setSsnNum(String ssnNum) {
        this.ssnNum = ssnNum;
    }

    public String getNicNum() {
        return nicNum;
    }

    public void setNicNum(String nicNum) {
        this.nicNum = nicNum;
    }

    public String getOtherId() {
        return otherId;
    }

    public void setOtherId(String otherId) {
        this.otherId = otherId;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }

    public Date getDrivingLicenseExpiryDate() {
        return drivingLicenseExpiryDate;
    }

    public void setDrivingLicenseExpiryDate(Date drivingLicenseExpiryDate) {
        this.drivingLicenseExpiryDate = drivingLicenseExpiryDate;
    }

    public Long getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(Long employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public PayGrade getPayGrade() {
        return payGrade;
    }

    public void setPayGrade(PayGrade payGrade) {
        this.payGrade = payGrade;
    }

    public String getWorkStationId() {
        return workStationId;
    }

    public void setWorkStationId(String workStationId) {
        this.workStationId = workStationId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPrivateEmail() {
        return privateEmail;
    }

    public void setPrivateEmail(String privateEmail) {
        this.privateEmail = privateEmail;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public String getIndirectSupervisors() {
        return indirectSupervisors;
    }

    public void setIndirectSupervisors(String indirectSupervisors) {
        this.indirectSupervisors = indirectSupervisors;
    }

    public CompanyStructure getDepartment() {
        return department;
    }

    public void setDepartment(CompanyStructure department) {
        this.department = department;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public String getCustom6() {
        return custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public String getCustom7() {
        return custom7;
    }

    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }

    public String getCustom8() {
        return custom8;
    }

    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }

    public String getCustom9() {
        return custom9;
    }

    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }

    public String getCustom10() {
        return custom10;
    }

    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Long ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Long getImmigrationStatus() {
        return immigrationStatus;
    }

    public void setImmigrationStatus(Long immigrationStatus) {
        this.immigrationStatus = immigrationStatus;
    }

    public Long getApprover1() {
        return approver1;
    }

    public void setApprover1(Long approver1) {
        this.approver1 = approver1;
    }

    public Long getApprover2() {
        return approver2;
    }

    public void setApprover2(Long approver2) {
        this.approver2 = approver2;
    }

    public Long getApprover3() {
        return approver3;
    }

    public void setApprover3(Long approver3) {
        this.approver3 = approver3;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality=" + nationality +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", maritalStatus=" + maritalStatus +
                ", ssnNum='" + ssnNum + '\'' +
                ", nicNum='" + nicNum + '\'' +
                ", otherId='" + otherId + '\'' +
                ", driving_license='" + driving_license + '\'' +
                ", drivingLicenseExpiryDate=" + drivingLicenseExpiryDate +
                ", employmentStatus=" + employmentStatus +
                ", jobTitle=" + jobTitle +
                ", payGrade=" + payGrade +
                ", workStationId='" + workStationId + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", province=" + province +
                ", postalCode='" + postalCode + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", privateEmail='" + privateEmail + '\'' +
                ", joinedDate=" + joinedDate +
                ", confirmationDate=" + confirmationDate +
                ", supervisor=" + supervisor +
                ", indirectSupervisors='" + indirectSupervisors + '\'' +
                ", department=" + department +
                ", custom1='" + custom1 + '\'' +
                ", custom2='" + custom2 + '\'' +
                ", custom3='" + custom3 + '\'' +
                ", custom4='" + custom4 + '\'' +
                ", custom5='" + custom5 + '\'' +
                ", custom6='" + custom6 + '\'' +
                ", custom7='" + custom7 + '\'' +
                ", custom8='" + custom8 + '\'' +
                ", custom9='" + custom9 + '\'' +
                ", custom10='" + custom10 + '\'' +
                ", terminationDate=" + terminationDate +
                ", notes='" + notes + '\'' +
                ", status=" + status +
                ", ethnicity=" + ethnicity +
                ", immigrationStatus=" + immigrationStatus +
                ", approver1=" + approver1 +
                ", approver2=" + approver2 +
                ", approver3=" + approver3 +
                '}';
    }
}
