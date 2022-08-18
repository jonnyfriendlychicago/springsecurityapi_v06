package com.jonfriend.springsecurityapi_v06.payload;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank
  	private String email;

	@NotBlank
	private String password;

	
	// instantiate the mdl
	public LoginRequest() {}
	  
	
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
	
	
}