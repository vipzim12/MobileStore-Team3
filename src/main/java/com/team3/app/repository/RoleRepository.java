package com.team3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
