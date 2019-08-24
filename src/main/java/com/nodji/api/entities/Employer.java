package com.nodji.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.nodji.api.enums.ProfileEnum;

@Entity
@Table(name = "employer")
public class Employer implements Serializable{

	private static final long serialVersionUID = -9169670240854558399L;


	private UUID id;
	private String name;
	private String email;
	private String pass;
	private String code;
	private BigDecimal hourValue;
	private Float hourWorked;
	private Float hourLunch;
	private ProfileEnum profile;
	private Date dateCreated;
	private Date dateUpdated;
	private Company company;
	private List<Register> registers;
	
	public Employer() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name="name", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email", nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="pass", nullable=false)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}


	@Column(name="code", nullable=false)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="hourValue", nullable=true)
	public BigDecimal getHourValue() {
		return hourValue;
	}

	public void setHourValue(BigDecimal hourValue) {
		this.hourValue = hourValue;
	}

	@Column(name="hourWorked", nullable=true)
	public Float getHourWorked() {
		return hourWorked;
	}

	public void setHourWorked(Float hourWorked) {
		this.hourWorked = hourWorked;
	}

	@Column(name="hourLunch", nullable=true)
	public Float getHourLunch() {
		return hourLunch;
	}

	public void setHourLunch(Float hourLunch) {
		this.hourLunch = hourLunch;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="profile", nullable=false)
	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
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
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(mappedBy="employer", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
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
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", code=" + code
				+ ", hourValue=" + hourValue + ", hourWorked=" + hourWorked + ", hourLunch=" + hourLunch + ", profile="
				+ profile + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + "]";
	}	
	
}
