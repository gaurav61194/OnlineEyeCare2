package com.onlineeyecare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//User method
@Entity
@Table(name = "User_Table1")
public class User {
	
	//Variables
	@Id
	@NotBlank(message = "UserName must be filled")
	private String userName;
	@NotBlank(message = "Password must be filled")
	@Size(min = 8, max = 12)
	private String password;
	@NotBlank(message = "Role must be filled")
	private String role;
	
	//getter and setter
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	//Constructor
	public User() {
		super();
	}
	
	public User(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}	
}
