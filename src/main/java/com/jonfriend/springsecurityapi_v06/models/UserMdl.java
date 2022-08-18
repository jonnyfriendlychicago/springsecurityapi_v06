package com.jonfriend.springsecurityapi_v06.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class UserMdl {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // BEGIN: entity-specific fields
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private Date lastLogin;
    
//    @Size(min=3)
//    private String username;
    
    @Size(min=3)
    private String password;
    
    @Transient
    private String passwordConfirm;
    
    // END: entity-specific fields

    // BEGIN: joins 
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id")
        )
    private List<RoleMdl> roleMdl;
    
    // END: joins
    
    // instantiate the model: 
    public UserMdl() {}
    
    // add methods to populate maintain createdAt/UpdatedAt
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }

    // begin: getters and setters

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public List<RoleMdl> getRoleMdl() {
		return roleMdl;
	}

	public void setRoleMdl(List<RoleMdl> roleMdl) {
		this.roleMdl = roleMdl;
	}


    
    // end: getters and setters
    
// end mdl
    
}

