package com.example.traveller.dto;

import com.example.traveller.entity.cat.SexStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@ApiModel
public class UserDto {

	private static final String VALID_EMAIL_ADDRESS_REGEX = "^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";

	@ApiModelProperty(value = "First name", required = true)
	@NotNull
	private String firstName;

	@ApiModelProperty(value = "Last name", required = true)
	@NotNull
	private String lastName;

	@ApiModelProperty(value = "Password", required = true)
	@NotNull
	private String password;

	@ApiModelProperty(value = "User name", required = true)
	@NotNull
	private String 	userName;

	@ApiModelProperty(value = "email", required = true)
	@Pattern(regexp = VALID_EMAIL_ADDRESS_REGEX)
	@NotNull
	private String email;

	@ApiModelProperty(value = "Date of birth", required = true)
	@NotNull
	private Date birthDate;

	@ApiModelProperty(value = "Sex", required = true)
	private SexStatus sex;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public SexStatus getSex() {
		return sex;
	}

	public void setSex(SexStatus sex) {
		this.sex = sex;
	}
}
