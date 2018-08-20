package com.team3.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team3.app.entities.GroupCategory;

@Repository
public interface GroupCategoryRepository extends JpaRepository<GroupCategory, Integer>{

}
