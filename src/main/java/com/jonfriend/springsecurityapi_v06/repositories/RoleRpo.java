package com.jonfriend.springsecurityapi_v06.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jonfriend.springsecurityapi_v06.models.RoleMdl;

@Repository
public interface RoleRpo extends CrudRepository<RoleMdl, Long> {

	List<RoleMdl> findAll();
    
    List<RoleMdl> findByName(String name);
}