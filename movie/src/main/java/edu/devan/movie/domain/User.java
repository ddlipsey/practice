package edu.devan.movie.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private String email;
	private String role;

	public User() {

	}

	public User(String firstName, String lastName, String loginId, String password, String email, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId
				+ ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

	

}
