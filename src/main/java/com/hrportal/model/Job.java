package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the Job database table.
 */
@Entity
@Table(name = "Job")
//@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(length = 100)
    private String attachment;

    @Lob
    private String benefits;

    @Temporal(TemporalType.TIMESTAMP)
    private Date closingDate;

    @Column(length = 20)
    private String code;

    private BigInteger company;

    private BigInteger country;

    private BigInteger currency;

    @Column(length = 100)
    private String department;

    @Lob
    private String description;

    @Column(nullable = false, length = 200)
    private String display;

    private BigInteger educationLevel;

    private BigInteger employementType;

    private BigInteger experienceLevel;

    private BigInteger industry;

    private BigInteger jobFunction;

    @Lob
    private String keywords;

    private BigInteger postedBy;

    @Lob
    private String requirements;

    private BigInteger salaryMax;

    private BigInteger salaryMin;

    @Lob
    private String shortDescription;

    @Column(length = 20)
    private String showSalary;

    @Column(length = 20)
    private String status;

    @Column(nullable = false, length = 200)
    private String title;

    //bi-directional many-to-one association to Application
    @OneToMany(mappedBy = "jobBean", fetch = FetchType.EAGER)
    private Set<Application> applications;

    //bi-directional many-to-one association to Call
    @OneToMany(mappedBy = "jobBean", fetch = FetchType.EAGER)
    private Set<Call> calls;

    //bi-directional many-to-one association to Interview
    @OneToMany(mappedBy = "jobBean", fetch = FetchType.EAGER)
    private Set<Interview> interviews;

    public Job() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachment() {
        return this.attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getBenefits() {
        return this.benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Date getClosingDate() {
        return this.closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigInteger getCompany() {
        return this.company;
    }

    public void setCompany(BigInteger company) {
        this.company = company;
    }

    public BigInteger getCountry() {
        return this.country;
    }

    public void setCountry(BigInteger country) {
        this.country = country;
    }

    public BigInteger getCurrency() {
        return this.currency;
    }

    public void setCurrency(BigInteger currency) {
        this.currency = currency;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public BigInteger getEducationLevel() {
        return this.educationLevel;
    }

    public void setEducationLevel(BigInteger educationLevel) {
        this.educationLevel = educationLevel;
    }

    public BigInteger getEmployementType() {
        return this.employementType;
    }

    public void setEmployementType(BigInteger employementType) {
        this.employementType = employementType;
    }

    public BigInteger getExperienceLevel() {
        return this.experienceLevel;
    }

    public void setExperienceLevel(BigInteger experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public BigInteger getIndustry() {
        return this.industry;
    }

    public void setIndustry(BigInteger industry) {
        this.industry = industry;
    }

    public BigInteger getJobFunction() {
        return this.jobFunction;
    }

    public void setJobFunction(BigInteger jobFunction) {
        this.jobFunction = jobFunction;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public BigInteger getPostedBy() {
        return this.postedBy;
    }

    public void setPostedBy(BigInteger postedBy) {
        this.postedBy = postedBy;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public BigInteger getSalaryMax() {
        return this.salaryMax;
    }

    public void setSalaryMax(BigInteger salaryMax) {
        this.salaryMax = salaryMax;
    }

    public BigInteger getSalaryMin() {
        return this.salaryMin;
    }

    public void setSalaryMin(BigInteger salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShowSalary() {
        return this.showSalary;
    }

    public void setShowSalary(String showSalary) {
        this.showSalary = showSalary;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Application> getApplications() {
        return this.applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public Application addApplication(Application application) {
        getApplications().add(application);
        application.setJobBean(this);

        return application;
    }

    public Application removeApplication(Application application) {
        getApplications().remove(application);
        application.setJobBean(null);

        return application;
    }

    public Set<Call> getCalls() {
        return this.calls;
    }

    public void setCalls(Set<Call> calls) {
        this.calls = calls;
    }

    public Call addCall(Call call) {
        getCalls().add(call);
        call.setJobBean(this);

        return call;
    }

    public Call removeCall(Call call) {
        getCalls().remove(call);
        call.setJobBean(null);

        return call;
    }

    public Set<Interview> getInterviews() {
        return this.interviews;
    }

    public void setInterviews(Set<Interview> interviews) {
        this.interviews = interviews;
    }

    public Interview addInterview(Interview interview) {
        getInterviews().add(interview);
        interview.setJobBean(this);

        return interview;
    }

    public Interview removeInterview(Interview interview) {
        getInterviews().remove(interview);
        interview.setJobBean(null);

        return interview;
    }

}