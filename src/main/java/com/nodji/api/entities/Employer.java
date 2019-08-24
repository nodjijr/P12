package com.nodji.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nodji.api.enums.ProfileEnum;

@Entity
@Table(name = "employer")
public class Employer implements Serializable{

	private static final long serialVersionUID = -9169670240854558399L;


	private UUID id;
	private String name;
	private String email;
	private String senha;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getHourValue() {
		return hourValue;
	}

	public void setHourValue(BigDecimal hourValue) {
		this.hourValue = hourValue;
	}

	public Float getHourWorked() {
		return hourWorked;
	}

	public void setHourWorked(Float hourWorked) {
		this.hourWorked = hourWorked;
	}

	public Float getHourLunch() {
		return hourLunch;
	}

	public void setHourLunch(Float hourLunch) {
		this.hourLunch = hourLunch;
	}

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}

}
