package com.uvik.repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uvik.api.beans.SNames;
import com.uvik.entity.Student;

@Repository
@Component
public interface StudentRepository extends MongoRepository<Student, String> 
{
	
		SNames findByfirstName(String firstName);
	
		public Student findTopByOrderByCreatedDateDesc();

		public List<Student> findFirstByOrderByFirstNameAsc();
		
		public List<Student> findByFirstNameStartingWith(String A);
		
		public List<Student> findFirstByOrderByFirstNameDesc();
		
		public List<Student> findFirst10ByOrderByFirstNameAsc();
		
		public List<Student> findByCreatedDateGreaterThanEqual(Instant from);

		public List<Student> findByCreatedDateGreaterThanEqual(LocalDate from);
}