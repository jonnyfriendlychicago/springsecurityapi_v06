package com.jonfriend.springsecurityapi_v06.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.jonfriend.springsecurityapi_v06.models.RoleMdl;
import com.jonfriend.springsecurityapi_v06.models.ERole;

//@Repository
public interface RoleRpo extends CrudRepository<RoleMdl, Long> {

	Optional<RoleMdl> findByName(String name);
	
	// above replaces below
	
//	List<RoleMdl> findAll();
//    
//    List<RoleMdl> findByName(String name);
}