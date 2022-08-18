package com.jonfriend.springsecurityapi_v06.payload;

import com.jonfriend.springsecurityapi_v06.models.UserMdl;

import lombok.Data;

@Data
public class JwtResponse {
  private String auth_token;
  private String type = "Bearer";
  private UserMdl user;

  public JwtResponse(String accessToken, UserMdl user) {
    this.auth_token = accessToken;
    this.user = user;
  }

  public String getauth_token() { // odd naming convention to match React requirements
    return auth_token;
  }

  public void setauth_token(String accessToken) { 
    this.auth_token = accessToken;
  }

}