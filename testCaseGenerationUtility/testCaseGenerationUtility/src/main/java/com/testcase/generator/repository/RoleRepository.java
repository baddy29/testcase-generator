package com.testcase.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testcase.generator.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

Role findByRole(String role);	
}
