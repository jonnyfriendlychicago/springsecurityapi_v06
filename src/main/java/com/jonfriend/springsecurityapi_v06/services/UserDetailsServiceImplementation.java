package com.jonfriend.springsecurityapi_v06.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jonfriend.springsecurityapi_v06.models.UserMdl;
import com.jonfriend.springsecurityapi_v06.repositories.UserRpo;
//import com.lee.demo.models.User;
//import com.lee.demo.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	@Autowired
	UserRpo userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserMdl user = userRepository.findByEmail(email);
		return UserDetailsImpl.build(user);
	}
}