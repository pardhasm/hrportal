package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the TrainingSessions database table.
 * 
 */
@Entity
@Table(name="TrainingSessions")
//@NamedQuery(name="TrainingSession.findAll", query="SELECT t FROM TrainingSession t")
public class TrainingSession extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=300)
	private String attachment;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private AttendanceType attendanceType;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(length=500)
	private String deliveryLocation;

	@Column(length=20)
	private DeliveryMethod deliveryMethod;

	@Lob
	private String description;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime dueDate;

	@Column(nullable=false, length=300)
	private String name;

	@Column(length=20)
	@Enumerated(EnumType.STRING)
	private Polar requireProof;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime scheduled;

	@Column(length=20)


    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime updated;

	//bi-directional many-to-one association to EmployeeTrainingSession
	@OneToMany(mappedBy="trainingSessionBean", fetch=FetchType.EAGER)
	private Set<EmployeeTrainingSession> employeeTrainingSessions;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="course", nullable=false)
	private Course course;

	public TrainingSession() {
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

    public DateTime getCreated() {
        return this.created;
	}

    public void setCreated(DateTime created) {
        this.created = created;
	}

	public String getDeliveryLocation() {
		return this.deliveryLocation;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public DateTime getDueDate() {
        return this.dueDate;
	}

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Polar getRequireProof() {
		return this.requireProof;
	}

	public void setRequireProof(Polar requireProof) {
		this.requireProof = requireProof;
	}

    public DateTime getScheduled() {
        return this.scheduled;
	}

    public void setScheduled(DateTime scheduled) {
        this.scheduled = scheduled;
	}


    public DateTime getUpdated() {
        return this.updated;
	}

    public void setUpdated(DateTime updated) {
        this.updated = updated;
	}

	public Set<EmployeeTrainingSession> getEmployeeTrainingSessions() {
		return this.employeeTrainingSessions;
	}

	public void setEmployeeTrainingSessions(Set<EmployeeTrainingSession> employeeTrainingSessions) {
		this.employeeTrainingSessions = employeeTrainingSessions;
	}

	public EmployeeTrainingSession addEmployeeTrainingSession(EmployeeTrainingSession employeeTrainingSession) {
		getEmployeeTrainingSessions().add(employeeTrainingSession);
		employeeTrainingSession.setTrainingSessionBean(this);

		return employeeTrainingSession;
	}

	public EmployeeTrainingSession removeEmployeeTrainingSession(EmployeeTrainingSession employeeTrainingSession) {
		getEmployeeTrainingSessions().remove(employeeTrainingSession);
		employeeTrainingSession.setTrainingSessionBean(null);

		return employeeTrainingSession;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public AttendanceType getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(AttendanceType attendanceType) {
		this.attendanceType = attendanceType;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
}