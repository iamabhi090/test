package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.entity.Data;

@Repository
public interface DataSourceRepository extends JpaRepository<Data, Long> {
	
	
	@Query("SELECT data from Data data WHERE data.registrationNumber = :registrationNumber")
	Data findByRegistrationNo(String registrationNumber);

}
