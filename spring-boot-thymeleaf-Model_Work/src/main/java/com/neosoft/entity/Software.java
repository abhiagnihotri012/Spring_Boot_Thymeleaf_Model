package com.neosoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "software")
public class Software {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long softwareId;
	
	@Column(name = "softName",nullable = false)
	private String softName;
	
	@Column(name = "client")
	private String client;
	
	@Column(name = "email")
	private String email;

	public Long getId() {
		return softwareId;
	}

	public void setId(Long id) {
		this.softwareId = id;
	}

	public String getFirstName() {
		return softName;
	}

	public void setFirstName(String firstName) {
		this.softName = firstName;
	}

	public String getLastName() {
		return client;
	}

	public void setLastName(String lastName) {
		this.client = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
