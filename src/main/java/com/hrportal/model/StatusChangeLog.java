package com.hrportal.model;

import org.joda.time.DateTime;

import javax.persistence.*;



/**
 * The persistent class for the StatusChangeLogs database table.
 * 
 */
@Entity
@Table(name="StatusChangeLogs")
//@NamedQuery(name="StatusChangeLog.findAll", query="SELECT s FROM StatusChangeLog s")
public class StatusChangeLog extends AbstractMutableEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Long id;

    @org.hibernate.annotations.Type(type = "updatedTime")
    private DateTime created;

	@Column(nullable=false, length=500)
	private String data;

	@Column(nullable=false)
    private Long element;

	@Column(name="status_from", length=20)
	@Enumerated(EnumType.STRING)
	private Approval statusFrom;

	@Column(name="status_to", length=20)
	@Enumerated(EnumType.STRING)
	private Approval statusTo;

	@Column(nullable=false, length=100)
	private String type;

	@Column(name="user_id")
    private Long userId;

	public StatusChangeLog() {
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

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

    public Long getElement() {
        return this.element;
	}

    public void setElement(Long element) {
        this.element = element;
	}

	public Approval getStatusFrom() {
		return this.statusFrom;
	}

	public void setStatusFrom(Approval statusFrom) {
		this.statusFrom = statusFrom;
	}

	public Approval getStatusTo() {
		return this.statusTo;
	}

	public void setStatusTo(Approval statusTo) {
		this.statusTo = statusTo;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public Long getUserId() {
        return this.userId;
	}

    public void setUserId(Long userId) {
        this.userId = userId;
	}

}