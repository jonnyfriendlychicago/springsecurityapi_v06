package com.jonfriend.springsecurityapi_v06.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
import lombok.Data;
import lombok.NoArgsConstructor;
*/


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
//@NoArgsConstructor
//@Data
@Table(name = "user", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "email") 
    })
public class UserMdl {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

//  @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY) // mappedBy must match attribute in child
//  @JsonIgnore
//  private List<Topic> topics;
//
//  @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY) // mappedBy must match attribute in child
//  @JsonIgnore
//  private List<Joke> jokes;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_role", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  @JsonIgnore
  private Set<RoleMdl> roles = new HashSet<>();

//begin: waht is this???
  public UserMdl(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public UserMdl( long id, String email ) {
    this.id = id;
    this.email = email;
  }

// end: waht is this???
  
  // instantiate the mdl -- just added, seems like it's needed????  how does it work without??
  public UserMdl() {}
  
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

public Set<RoleMdl> getRoles() {
	return roles;
}

public void setRoles(Set<RoleMdl> roles) {
	this.roles = roles;
}
  
  

}