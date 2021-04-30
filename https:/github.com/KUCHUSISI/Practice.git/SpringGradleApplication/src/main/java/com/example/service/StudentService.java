package com.example.service;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;

import com.example.controller.StudentServiceController;
import com.example.mapper.DocDate;
import com.example.mapper.Pojo;
import com.example.mapper.SData;
import com.example.mapper.StudentDetails;
import com.example.mapper.StudentPojo;
import com.example.repository.StudentRepository;
import com.example.student.Student;

import ch.qos.logback.classic.Logger;

@org.springframework.stereotype.Service
@ComponentScan("com.example.repository")
public class StudentService
{
	@Autowired(required = true)
	StudentRepository studentRepositorty;
	
	Logger logger=(Logger) LoggerFactory.getLogger(StudentServiceController.class);
	ModelMapper mapper=new ModelMapper();
	
	public SData findStudentByFirstName(String FirstName)
	{
		return studentRepositorty.findByfirstName(FirstName);
	}
	public Student insertStudentData(Student data)
	{
		return studentRepositorty.save(data);

	}

	public Student findTheLatestDocumentByDate()
	{
		return studentRepositorty.findTopByOrderByCreatedDateDesc();
	}
	
	public List<Pojo> findTop10StudentDeatils()
	{
		return studentRepositorty.findFirst10ByOrderByFirstNameAsc();
	}
	
	public List<StudentDetails> findStudentsHavingNameWithCharacters(String A)
	{
		return studentRepositorty.findByFirstNameStartingWith(A);
	}

	public List<StudentPojo> findStudentOrderByFirstNameDesc()
	{
		return studentRepositorty.findFirstByOrderByFirstNameDesc();
	}
	
	public List<StudentPojo> findStudentOrderByFirstNameAsc()
	{
		return studentRepositorty.findFirstByOrderByFirstNameAsc();
	}

	public List<DocDate> findTheDocsCreatedInLast3Days()
	{
		  Instant date=Instant.now();
		  return studentRepositorty.findByCreatedDateGreaterThanEqual(date.minusSeconds(72*3600));

	}
	// customsing by using post not by using get method
	

	public List<DocDate> findTheDocsCreatedInLast10Hours()
	{
		  Instant date=Instant.now();
		  return studentRepositorty.findByCreatedDateGreaterThanEqual(date.minusSeconds(10*3600));
	}
}