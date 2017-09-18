package com.hrportal.model;

import javax.persistence.*;
import java.io.Serializable;
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

    private Long company;

    private Long country;

    private Long currency;

    @Column(length = 100)
    private String department;

    @Lob
    private String description;

    @Column(nullable = false, length = 200)
    private String display;

    private Long educationLevel;

    private Long employementType;

    private Long experienceLevel;

    private Long industry;

    private Long jobFunction;

    @Lob
    private String keywords;

    private Long postedBy;

    @Lob
    private String requirements;

    private Long salaryMax;

    private Long salaryMin;

    @Lob
    private String shortDescription;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Polar showSalary;

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

    public Long getCompany() {
        return this.company;
    }

    public void setCompany(Long company) {
        this.company = company;
    }

    public Long getCountry() {
        return this.country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getCurrency() {
        return this.currency;
    }

    public void setCurrency(Long currency) {
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

    public Long getEducationLevel() {
        return this.educationLevel;
    }

    public void setEducationLevel(Long educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Long getEmployementType() {
        return this.employementType;
    }

    public void setEmployementType(Long employementType) {
        this.employementType = employementType;
    }

    public Long getExperienceLevel() {
        return this.experienceLevel;
    }

    public void setExperienceLevel(Long experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Long getIndustry() {
        return this.industry;
    }

    public void setIndustry(Long industry) {
        this.industry = industry;
    }

    public Long getJobFunction() {
        return this.jobFunction;
    }

    public void setJobFunction(Long jobFunction) {
        this.jobFunction = jobFunction;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getPostedBy() {
        return this.postedBy;
    }

    public void setPostedBy(Long postedBy) {
        this.postedBy = postedBy;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Long getSalaryMax() {
        return this.salaryMax;
    }

    public void setSalaryMax(Long salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Long getSalaryMin() {
        return this.salaryMin;
    }

    public void setSalaryMin(Long salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getShortDescription() {
        return this.shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Polar getShowSalary() {
        return this.showSalary;
    }

    public void setShowSalary(Polar showSalary) {
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