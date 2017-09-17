package com.hrportal.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Jobs")
public class Job extends AbstractMutableEntity {

    @Id
    @NotNull
    @Length(max = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @Length(max = 200)
    private String title;
    @Column
    private String shortDescription;
    @Column
    private String description;
    @Column
    private String requirements;
    @Column
    private String benefits;
    @Column
    private Long country;
    @Column
    private Long company;
    @Length(max = 100)
    private String department;
    @Length(max = 20)
    private String code;
    @Column
    private Long employmentType;
    @Column
    private Long industry;
    @Column
    private Long experienceLevel;
    @Column
    private Long jobFunction;
    @Column
    private Long educationLevel;
    @Column
    private Long currency;
    @Column
    @Enumerated(EnumType.STRING)
    private Polar showSalary;
    @Column
    private Long salaryMin;
    @Column
    private Long salaryMax;
    @Column
    private String keywords;
    @Column
    @Enumerated(EnumType.STRING)
    private JobStatus status;
    @Column
    @Type(type = "updatedTime")
    private DateTime closingDate;
    @Column
    @Length(max = 100)
    private String attachment;
    @Column
    @Length(max = 200)
    @NotNull
    private String display;
    @Column
    private Long postedBy;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getCompany() {
        return company;
    }

    public void setCompany(Long company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(Long employmentType) {
        this.employmentType = employmentType;
    }

    public Long getIndustry() {
        return industry;
    }

    public void setIndustry(Long industry) {
        this.industry = industry;
    }

    public Long getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(Long experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Long getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(Long jobFunction) {
        this.jobFunction = jobFunction;
    }

    public Long getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Long educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Long getCurrency() {
        return currency;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public Polar getShowSalary() {
        return showSalary;
    }

    public void setShowSalary(Polar showSalary) {
        this.showSalary = showSalary;
    }

    public Long getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Long salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Long getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Long salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public DateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(DateTime closingDate) {
        this.closingDate = closingDate;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Long getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Long postedBy) {
        this.postedBy = postedBy;
    }
}
