package com.sankar.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankar.tech.entity.MyEntity1;

@Repository
public interface MyEntiry1Repository extends JpaRepository<MyEntity1, Integer> {
	
	
	

}
