package com.nodji.api.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = -7499817934294484139L;
	
	private UUID id;
	private String description;
	private String code;
	private Date dateCreated;
	private Date dateUpdated;
	private List<Employer> employes;
	
	public Company() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column(name="description", nullable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="code", nullable=false)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
	@OneToMany(mappedBy="company", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employer> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employer> employes) {
		this.employes = employes;
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
		return "Company [id=" + id + ", description=" + description + ", code=" + code + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + "]";
	}

}
