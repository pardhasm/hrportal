package com.hrportal.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Candidates")
public class Candidate extends AbstractMutableEntity{
	
	@Id
	@Length(max = 20)
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @Length(max = 100)
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @Length(max = 100)
    @NotNull
    private String lastName;

    @Length(max = 20)
    private Long nationality;
    private Date birthday;
	private String gender;
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Length(max = 100)
	private String address1;
	
	@Length(max = 100)
	private String address2;
	
	@Length(max = 150)
	private String city;
	
	@Length(max = 2)
	private String country;
	
	@Length(max = 20)
    private Long province;

    @Length(max = 20)
	private String postalCode;
	
	@Length(max = 200)
	private String email;

    @Column(name = "home_phone")
    @Length(max = 50)
    private String homePhone;

    @Column(name = "mobile_phone")
    @Length(max = 50)
    private String mobilePhone;

    @Length(max = 200)
    @NotNull
	private String cv_title;
	
	@Length(max = 150)
	private String cv;
	private String cvtext;
	private String industry;
	
	@Length(max = 150)
	private String profileImage;
    @Column(name = "head_line")
    private String headLine;
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
    private String preferredJobtype;
    private String preferredCountries;
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

    @Override
    public Long getId() {
        return id;
	}

    @Override
    public void setId(Long id) {
        this.id = id;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getNationality() {
        return nationality;
	}

    public void setNationality(Long nationality) {
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

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public Long getProvince() {
        return province;
	}

    public void setProvince(Long province) {
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

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
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

    public String getPreferredJobtype() {
        return preferredJobtype;
    }

    public void setPreferredJobtype(String preferredJobtype) {
        this.preferredJobtype = preferredJobtype;
    }

    public String getPreferredCountries() {
        return preferredCountries;
    }

    public void setPreferredCountries(String preferredCountries) {
        this.preferredCountries = preferredCountries;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Candidate{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", nationality=").append(nationality);
        sb.append(", birthday=").append(birthday);
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", address1='").append(address1).append('\'');
        sb.append(", address2='").append(address2).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", province=").append(province);
        sb.append(", postalCode='").append(postalCode).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", homePhone='").append(homePhone).append('\'');
        sb.append(", mobilePhone='").append(mobilePhone).append('\'');
        sb.append(", cv_title='").append(cv_title).append('\'');
        sb.append(", cv='").append(cv).append('\'');
        sb.append(", cvtext='").append(cvtext).append('\'');
        sb.append(", industry='").append(industry).append('\'');
        sb.append(", profileImage='").append(profileImage).append('\'');
        sb.append(", headLine='").append(headLine).append('\'');
        sb.append(", objective='").append(objective).append('\'');
        sb.append(", work_history='").append(work_history).append('\'');
        sb.append(", education='").append(education).append('\'');
        sb.append(", skills='").append(skills).append('\'');
        sb.append(", references='").append(references).append('\'');
        sb.append(", linkedInUrl='").append(linkedInUrl).append('\'');
        sb.append(", linkedInData='").append(linkedInData).append('\'');
        sb.append(", totalYearsOfExperience=").append(totalYearsOfExperience);
        sb.append(", totalMonthsOfExperience=").append(totalMonthsOfExperience);
        sb.append(", htmlCVData='").append(htmlCVData).append('\'');
        sb.append(", generatedCVFile='").append(generatedCVFile).append('\'');
        sb.append(", expectedSalary=").append(expectedSalary);
        sb.append(", preferredJobtype='").append(preferredJobtype).append('\'');
        sb.append(", preferredCountries='").append(preferredCountries).append('\'');
        sb.append(", tags='").append(tags).append('\'');
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", calls='").append(calls).append('\'');
        sb.append(", age=").append(age);
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", linkedInProfileLink='").append(linkedInProfileLink).append('\'');
        sb.append(", linkedInProfileId='").append(linkedInProfileId).append('\'');
        sb.append(", facebookProfileLink='").append(facebookProfileLink).append('\'');
        sb.append(", facebookProfileId='").append(facebookProfileId).append('\'');
        sb.append(", twitterProfileLink='").append(twitterProfileLink).append('\'');
        sb.append(", twitterProfileId='").append(twitterProfileId).append('\'');
        sb.append(", googleProfileLink='").append(googleProfileLink).append('\'');
        sb.append(", googleProfileId='").append(googleProfileId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
