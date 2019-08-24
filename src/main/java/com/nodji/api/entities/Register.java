package com.nodji.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.nodji.api.enums.TypeEnum;

@Entity
@Table(name = "register")
public class Register implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028996421343658863L;

	private UUID id;
	private Date dateRegister;
	private String description;
	private String local;
	private TypeEnum type;
	private Date dateCreated;
	private Date dateUpdated;
	private Employer employer;
	
	public Register() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateRegister", nullable=false)
	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	@Column(name="description", nullable=false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="local", nullable=false)
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="type", nullable=false)
	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	@Column(name="dateCreated", nullable=false)
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name="dateUpdated", nullable=false)
	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	@PreUpdate
	public void preUpdate() {
		dateUpdated = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date actual = new Date();
		dateCreated = actual;
		dateUpdated = actual;
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", dateRegister=" + dateRegister + ", description=" + description + ", local="
				+ local + ", type=" + type + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}
	
}
