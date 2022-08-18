package com.jonfriend.springsecurityapi_v06.payload;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class SignupRequest {
  
  private String email;

  private Set<String> role;

  
  private String password;

  
  private String confirm_password;


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public Set<String> getRole() {
	return role;
}


public void setRole(Set<String> role) {
	this.role = role;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getConfirm_password() {
	return confirm_password;
}


public void setConfirm_password(String confirm_password) {
	this.confirm_password = confirm_password;
}
  
  
  
}

