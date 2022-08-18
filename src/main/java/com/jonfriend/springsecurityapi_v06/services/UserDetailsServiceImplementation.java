package com.jonfriend.springsecurityapi_v06.services;

import java.util.ArrayList;
import java.util.List;
import com.jonfriend.springsecurityapi_v06.models.RoleMdl;
import com.jonfriend.springsecurityapi_v06.models.UserMdl;
import com.jonfriend.springsecurityapi_v06.repositories.UserRpo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

//	make below an autowire, after everything working
	private UserRpo userRpo;
    public UserDetailsServiceImplementation(UserRpo userRpo){
        this.userRpo = userRpo;
    } 
    
    @Override // loadUserByUsername is a misleading name here because we are using email for login credentials

    //    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //    UserMdl userMdl = userRpo.findByUsername(username);
        // above replaced by below
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
            UserMdl userMdl = userRpo.findByEmail(email);
        
        if(userMdl == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(userMdl.getEmail(), userMdl.getPassword(), getAuthorities(userMdl));
    }
    
    private List<GrantedAuthority> getAuthorities(UserMdl userMdl){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(RoleMdl roleMdl : userMdl.getRoleMdl()) {  
        	// JRF role above shoudl be renamed roleMdl for consistency, back to this later
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleMdl.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
    
    
}
