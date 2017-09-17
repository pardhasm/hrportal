package com.hrportal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Candidates")
public class Candidate extends AbstractMutableEntity{
	
	@Id
	@Length(max = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Length(max = 100)
    @NotNull
	private String first_name;
	
	@Length(max = 100)
    @NotNull
	private String last_name;
	
	@Length(max = 20)
	private long nationality;
	private Date birthday;
	private String gender;
	private String marital_status;
	
	@Length(max = 100)
	private String address1;
	
	@Length(max = 100)
	private String address2;
	
	@Length(max = 150)
	private String city;
	
	@Length(max = 2)
	private String country;
	
	@Length(max = 20)
	private long province;
	
	@Length(max = 20)
	private String postalCode;
	
	@Length(max = 200)
	private String email;
	
	@Length(max = 50)
	private String home_phone;
	
	@Length(max = 50)
	private String mobile_phone;
	
	@Length(max = 200)
    @NotNull
	private String cv_title;
	
	@Length(max = 150)
	private String cv;
	private String cvtext;
	private String industry;
	
	@Length(max = 150)
	private String profileImage;
	private String head_line;
	private String objective;
	private String work_history;
	private String education;
	private String skills;
	private String references;
	
	@Length(max = 150)
	private String linkedInUrl;
	private String linkedInData;
	
	@Length(max = 11)
	private int totalYearsOfExperience;
	
	@Length(max = 11)
	private int totalMonthsOfExperience;
	private String htmlCVData;
	
	@Length(max = 150)
	private String generatedCVFile;
	
	@Length(max = 11)
	private int expectedSalary;
	
	@Length(max = 60)
	private String preferedJobtype;
	private String preferedCountries;
	private String tags;
	private String notes;
	private String calls;
	
	@Length(max = 11)
	private int age;
	
	@Length(max = 100)
	private String hash;
	
	@Length(max = 250)
	private String linkedInProfileLink;
	
	@Length(max = 50)
	private String linkedInProfileId;
	
	@Length(max = 250)
	private String facebookProfileLink;
	
	@Length(max = 50)
	private String facebookProfileId;
	
	@Length(max = 250)
	private String twitterProfileLink;
	
	@Length(max = 50)
	private String twitterProfileId;
	
	@Length(max = 250)
	private String googleProfileLink;
	
	@Length(max = 50)
	private String googleProfileId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public long getNationality() {
		return nationality;
	}

	public void setNationality(long nationality) {
		this.nationality = nationality;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarital_status() {
		return marital_status;
	}

	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getProvince() {
		return province;
	}

	public void setProvince(long province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getCv_title() {
		return cv_title;
	}

	public void setCv_title(String cv_title) {
		this.cv_title = cv_title;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getCvtext() {
		return cvtext;
	}

	public void setCvtext(String cvtext) {
		this.cvtext = cvtext;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getHead_line() {
		return head_line;
	}

	public void setHead_line(String head_line) {
		this.head_line = head_line;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getWork_history() {
		return work_history;
	}

	public void setWork_history(String work_history) {
		this.work_history = work_history;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getLinkedInData() {
		return linkedInData;
	}

	public void setLinkedInData(String linkedInData) {
		this.linkedInData = linkedInData;
	}

	public int getTotalYearsOfExperience() {
		return totalYearsOfExperience;
	}

	public void setTotalYearsOfExperience(int totalYearsOfExperience) {
		this.totalYearsOfExperience = totalYearsOfExperience;
	}

	public int getTotalMonthsOfExperience() {
		return totalMonthsOfExperience;
	}

	public void setTotalMonthsOfExperience(int totalMonthsOfExperience) {
		this.totalMonthsOfExperience = totalMonthsOfExperience;
	}

	public String getHtmlCVData() {
		return htmlCVData;
	}

	public void setHtmlCVData(String htmlCVData) {
		this.htmlCVData = htmlCVData;
	}

	public String getGeneratedCVFile() {
		return generatedCVFile;
	}

	public void setGeneratedCVFile(String generatedCVFile) {
		this.generatedCVFile = generatedCVFile;
	}

	public int getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(int expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getPreferedJobtype() {
		return preferedJobtype;
	}

	public void setPreferedJobtype(String preferedJobtype) {
		this.preferedJobtype = preferedJobtype;
	}

	public String getPreferedCountries() {
		return preferedCountries;
	}

	public void setPreferedCountries(String preferedCountries) {
		this.preferedCountries = preferedCountries;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCalls() {
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getLinkedInProfileLink() {
		return linkedInProfileLink;
	}

	public void setLinkedInProfileLink(String linkedInProfileLink) {
		this.linkedInProfileLink = linkedInProfileLink;
	}

	public String getLinkedInProfileId() {
		return linkedInProfileId;
	}

	public void setLinkedInProfileId(String linkedInProfileId) {
		this.linkedInProfileId = linkedInProfileId;
	}

	public String getFacebookProfileLink() {
		return facebookProfileLink;
	}

	public void setFacebookProfileLink(String facebookProfileLink) {
		this.facebookProfileLink = facebookProfileLink;
	}

	public String getFacebookProfileId() {
		return facebookProfileId;
	}

	public void setFacebookProfileId(String facebookProfileId) {
		this.facebookProfileId = facebookProfileId;
	}

	public String getTwitterProfileLink() {
		return twitterProfileLink;
	}

	public void setTwitterProfileLink(String twitterProfileLink) {
		this.twitterProfileLink = twitterProfileLink;
	}

	public String getTwitterProfileId() {
		return twitterProfileId;
	}

	public void setTwitterProfileId(String twitterProfileId) {
		this.twitterProfileId = twitterProfileId;
	}

	public String getGoogleProfileLink() {
		return googleProfileLink;
	}

	public void setGoogleProfileLink(String googleProfileLink) {
		this.googleProfileLink = googleProfileLink;
	}

	public String getGoogleProfileId() {
		return googleProfileId;
	}

	public void setGoogleProfileId(String googleProfileId) {
		this.googleProfileId = googleProfileId;
	}
	
	
	

}
