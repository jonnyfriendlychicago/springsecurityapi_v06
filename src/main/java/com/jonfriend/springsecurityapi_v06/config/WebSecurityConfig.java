package com.jonfriend.springsecurityapi_v06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	private UserDetailsService userDetailsService; 
	
	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	// JRF the word 'public' is default and therefore extraneous above
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.
	            authorizeRequests()
//	                .antMatchers("/css/**", "/js/**", "/register").permitAll()
	                .antMatchers("/css/**", "/js/**", "/register", "/login").permitAll()
//	                .antMatchers("/admin/**").access("hasRole('ADMIN')")
	                .antMatchers("/admin/**").access("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .usernameParameter("email") // use email instead of username for login 
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
		
		return http.build();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    } 
	
// end config
}
