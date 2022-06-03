package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ds.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,  Integer> {
	
}
