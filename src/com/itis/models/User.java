package com.itis.models;

public class User extends BaseModel {

	private String name;
	private String email;
	private String password;
	private String passwordConfirmation;
	
	public User() {
		this("", "", "", "");
	}
	
	public User(String name, String email, String password, String passwordConfirmation) {
		setAdditionalUrl();
		setTagName();
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@Override
	public void setAdditionalUrl() {
		additionalUrl = "/register?sn=false&_requestid=604780";
	}

	@Override
	public void setTagName() {
		tagName = "/com/mvideo/userprofiling/RegistrationFormHandler.register";
		
	}
}
