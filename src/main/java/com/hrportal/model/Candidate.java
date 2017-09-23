package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


/**
 * The persistent class for the Candidates database table.
 */
@Entity
@Table(name = "Candidates")
//@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate extends AbstractMutableEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String address1;

    @Column(length = 100)
    private String address2;

    private int age;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime birthday;

    @Lob
    private String calls;

    @Column(length = 150)
    private String city;

    @Column(length = 2)
    private String country;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

    @Column(length = 150)
    private String cv;

    @Column(name = "cv_title", nullable = false, length = 200)
    @NotNull
    private String cvTitle;

    @Lob
    private String cvtext;

    @Lob
    private String education;

    @Column(length = 200)
    private String email;

    private int expectedSalary;

    @Column(length = 50)
    private String facebookProfileId;

    @Column(length = 250)
    private String facebookProfileLink;

    @Column(name = "first_name", nullable = false, length = 100)
    @NotNull
    private String firstName;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 150)
    private String generatedCVFile;

    @Column(length = 50)
    private String googleProfileId;

    @Column(length = 250)
    private String googleProfileLink;

    @Column(length = 100)
    private String hash;

    @Lob
    @Column(name = "head_line")
    private String headLine;

    @Column(name = "home_phone", length = 50)
    private String homePhone;

    @Lob
    private String htmlCVData;

    @Lob
    private String industry;

    @Column(name = "last_name", nullable = false, length = 100)
    @NotNull
    private String lastName;

    @Lob
    private String linkedInData;

    @Column(length = 50)
    private String linkedInProfileId;

    @Column(length = 250)
    private String linkedInProfileLink;

    @Column(length = 500)
    private String linkedInUrl;

    @Column(name = "marital_status", length = 20)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "mobile_phone", length = 50)
    private String mobilePhone;

    private Long nationality;

    @Lob
    private String notes;

    @Lob
    private String objective;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Lob
    private String preferedCountries;

    @Column(length = 60)
    private String preferedJobtype;

    @Lob
    private String preferedPositions;

    @Column(length = 150)
    private String profileImage;

    private Long province;

    @Lob
    private String referees;

    @Lob
    private String skills;

    @Lob
    private String tags;

    private int totalMonthsOfExperience;

    private int totalYearsOfExperience;

    @Column(length = 50)
    private String twitterProfileId;

    @Column(length = 250)
    private String twitterProfileLink;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

    @Lob
    @Column(name = "work_history")
    private String workHistory;

    //bi-directional many-to-one association to Application
    @OneToMany(mappedBy = "candidateBean", fetch = FetchType.EAGER)
    private Set<Application> applications;

    //bi-directional many-to-one association to Call
    @OneToMany(mappedBy = "candidateBean", fetch = FetchType.EAGER)
    private Set<Call> callsSet;

    //bi-directional many-to-one association to Interview
    @OneToMany(mappedBy = "candidateBean", fetch = FetchType.EAGER)
    private Set<Interview> interviews;

    public Candidate() {
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DateTime getBirthday() {
        return this.birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    public String getCalls() {
        return this.calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public DateTime getCreated() {
        return this.created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public String getCv() {
        return this.cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getCvTitle() {
        return this.cvTitle;
    }

    public void setCvTitle(String cvTitle) {
        this.cvTitle = cvTitle;
    }

    public String getCvtext() {
        return this.cvtext;
    }

    public void setCvtext(String cvtext) {
        this.cvtext = cvtext;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getExpectedSalary() {
        return this.expectedSalary;
    }

    public void setExpectedSalary(int expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getFacebookProfileId() {
        return this.facebookProfileId;
    }

    public void setFacebookProfileId(String facebookProfileId) {
        this.facebookProfileId = facebookProfileId;
    }

    public String getFacebookProfileLink() {
        return this.facebookProfileLink;
    }

    public void setFacebookProfileLink(String facebookProfileLink) {
        this.facebookProfileLink = facebookProfileLink;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGeneratedCVFile() {
        return this.generatedCVFile;
    }

    public void setGeneratedCVFile(String generatedCVFile) {
        this.generatedCVFile = generatedCVFile;
    }

    public String getGoogleProfileId() {
        return this.googleProfileId;
    }

    public void setGoogleProfileId(String googleProfileId) {
        this.googleProfileId = googleProfileId;
    }

    public String getGoogleProfileLink() {
        return this.googleProfileLink;
    }

    public void setGoogleProfileLink(String googleProfileLink) {
        this.googleProfileLink = googleProfileLink;
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getHeadLine() {
        return this.headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getHtmlCVData() {
        return this.htmlCVData;
    }

    public void setHtmlCVData(String htmlCVData) {
        this.htmlCVData = htmlCVData;
    }

    public String getIndustry() {
        return this.industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLinkedInData() {
        return this.linkedInData;
    }

    public void setLinkedInData(String linkedInData) {
        this.linkedInData = linkedInData;
    }

    public String getLinkedInProfileId() {
        return this.linkedInProfileId;
    }

    public void setLinkedInProfileId(String linkedInProfileId) {
        this.linkedInProfileId = linkedInProfileId;
    }

    public String getLinkedInProfileLink() {
        return this.linkedInProfileLink;
    }

    public void setLinkedInProfileLink(String linkedInProfileLink) {
        this.linkedInProfileLink = linkedInProfileLink;
    }

    public String getLinkedInUrl() {
        return this.linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Long getNationality() {
        return this.nationality;
    }

    public void setNationality(Long nationality) {
        this.nationality = nationality;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getObjective() {
        return this.objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPreferedCountries() {
        return this.preferedCountries;
    }

    public void setPreferedCountries(String preferedCountries) {
        this.preferedCountries = preferedCountries;
    }

    public String getPreferedJobtype() {
        return this.preferedJobtype;
    }

    public void setPreferedJobtype(String preferedJobtype) {
        this.preferedJobtype = preferedJobtype;
    }

    public String getPreferedPositions() {
        return this.preferedPositions;
    }

    public void setPreferedPositions(String preferedPositions) {
        this.preferedPositions = preferedPositions;
    }

    public String getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Long getProvince() {
        return this.province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public String getReferees() {
        return this.referees;
    }

    public void setReferees(String referees) {
        this.referees = referees;
    }

    public String getSkills() {
        return this.skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTotalMonthsOfExperience() {
        return this.totalMonthsOfExperience;
    }

    public void setTotalMonthsOfExperience(int totalMonthsOfExperience) {
        this.totalMonthsOfExperience = totalMonthsOfExperience;
    }

    public int getTotalYearsOfExperience() {
        return this.totalYearsOfExperience;
    }

    public void setTotalYearsOfExperience(int totalYearsOfExperience) {
        this.totalYearsOfExperience = totalYearsOfExperience;
    }

    public String getTwitterProfileId() {
        return this.twitterProfileId;
    }

    public void setTwitterProfileId(String twitterProfileId) {
        this.twitterProfileId = twitterProfileId;
    }

    public String getTwitterProfileLink() {
        return this.twitterProfileLink;
    }

    public void setTwitterProfileLink(String twitterProfileLink) {
        this.twitterProfileLink = twitterProfileLink;
    }

    public DateTime getUpdated() {
        return this.updated;
    }

    public void setUpdated(DateTime updated) {
        this.updated = updated;
    }

    public String getWorkHistory() {
        return this.workHistory;
    }

    public void setWorkHistory(String workHistory) {
        this.workHistory = workHistory;
    }

    public Set<Application> getApplications() {
        return this.applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public Application addApplication(Application application) {
        getApplications().add(application);
        application.setCandidateBean(this);

        return application;
    }

    public Application removeApplication(Application application) {
        getApplications().remove(application);
        application.setCandidateBean(null);

        return application;
    }

    public Set<Call> getCallsSet() {
        return this.callsSet;
    }

    public void setCallsSet(Set<Call> callsSet) {
        this.callsSet = callsSet;
    }

    public Call addCallsSet(Call callsSet) {
        getCallsSet().add(callsSet);
        callsSet.setCandidateBean(this);

        return callsSet;
    }

    public Call removeCallsSet(Call callsSet) {
        getCallsSet().remove(callsSet);
        callsSet.setCandidateBean(null);

        return callsSet;
    }

    public Set<Interview> getInterviews() {
        return this.interviews;
    }

    public void setInterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }

    public Interview addInterview(Interview interview) {
        getInterviews().add(interview);
        interview.setCandidateBean(this);

        return interview;
    }

    public Interview removeInterview(Interview interview) {
        getInterviews().remove(interview);
        interview.setCandidateBean(null);

        return interview;
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
}