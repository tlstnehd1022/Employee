package com.hybrid.model;

import java.util.Date;

import com.hybrid.exception.PasswordNotMatchingException;

/*
 * Model Object
 * Value Object
 * Transfer Object
 * Beans 1. property
 * 		 2. event
 * 		 3. 기능(method)
*/

public class Member {
	long id;
	String email;
	String name;
	String password;
	Date registerDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public void changePassword(String oldPasswd, String newPasswd){
		if(!this.password.equals(oldPasswd)){
			throw new PasswordNotMatchingException();
			
		}
		this.password = newPasswd;
	}
	
	
}
