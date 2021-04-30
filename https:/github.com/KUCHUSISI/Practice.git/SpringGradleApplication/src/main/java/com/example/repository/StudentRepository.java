package com.example.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.mapper.DocDate;
import com.example.mapper.Pojo;
import com.example.mapper.SData;
import com.example.mapper.StudentDetails;
import com.example.mapper.StudentPojo;
import com.example.student.Student;

@Repository
@Component
public interface StudentRepository extends MongoRepository<Student, String> 
{
	
	SData findByfirstName(String firstName);
	// Fetch latest document by crteated date 
	// Fetch first document after ordering by First name alphabetically
	// Fetch first ten document after ordering by First name alphabetically

//		//find date based on date attriv=bute which is automatically inserted 
	// finding last 10 hours data
	//finding last 3 days data 
	
	
		public Student findTopByOrderByCreatedDateDesc();

		public List<StudentPojo> findFirstByOrderByFirstNameAsc();
		
		public List<StudentDetails> findByFirstNameStartingWith(String A);
		
		public List<StudentPojo> findFirstByOrderByFirstNameDesc();
		
		public List<Pojo> findFirst10ByOrderByFirstNameAsc();
		
//		public List<DocDate> findStudentByOrderByCreatedDateDesc(Instant from,Instant to);
		
		public List<DocDate> findByCreatedDateGreaterThanEqual(Instant from);


}