package com.example.traveller.entity;

import com.example.traveller.entity.cat.SexStatus;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@NotNull
	@Size(min = 4, max = 100)
	@Column(name = "user_name", unique = true)
	private String username;

	@NotNull
	@Size(min = 4, max = 50)
	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Size(min = 4, max = 50)
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Size(max = 500)
	@Column(name = "password")
	private String password;

	@NotNull
	@Size(max = 1000)
	@Column(name = "salt")
	private String salt;

	@NotNull
	@Column(name = "birth_date")
	private Date birthDate;

	@NotNull
	@Size(max = 100)
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "is_active")
	private boolean is_active;

	@Column(name = "id_cat_sex")
	@Convert(converter = SexStatus.Converter.class)
	private SexStatus sexStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public SexStatus getSexStatus() {
		return sexStatus;
	}

	public void setSexStatus(SexStatus sexStatus) {
		this.sexStatus = sexStatus;
	}
}
