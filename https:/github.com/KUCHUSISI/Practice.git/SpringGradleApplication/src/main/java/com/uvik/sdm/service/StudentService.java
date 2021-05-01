package com.uvik.sdm.service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.uvik.api.beans.DocDate;
import com.uvik.api.beans.SNames;
import com.uvik.api.beans.StudentDetails;
import com.uvik.api.beans.StudentData;
import com.uvik.entity.Student;
import com.uvik.repository.StudentRepository;

@Service
public class StudentService
{
	StudentRepository studentRepository;
	
	public SNames findStudentByFirstName(String FirstName)
	{
		return studentRepository.findByfirstName(FirstName);
	}
	public Student insertStudentData(Student data)
	{
		return studentRepository.save(data);

	}

	public Student findTheLatestDocumentByDate()
	{
		return studentRepository.findTopByOrderByCreatedDateDesc();
	}
	
	public List<SNames> findTop10StudentDetails()
	{
		return studentRepository.findFirst10ByOrderByFirstNameAsc().stream()
				.map(s -> new SNames(s.firstName,s.lastName)).collect(Collectors.toList());
	}
	
	public List<StudentDetails> findStudentsHavingNameWithCharacters(String A)
	{
		return studentRepository.findByFirstNameStartingWith(A).stream()
				.map(s -> new StudentDetails(s.firstName,s.lastName)).collect(Collectors.toList());
	}

	public List<StudentData> findStudentOrderByFirstNameDesc()
	{
		
		return studentRepository.findFirstByOrderByFirstNameDesc().stream()
				.map(s -> new StudentData(s.firstName,s.lastName)).collect(Collectors.toList());
	}
	
	public List<StudentData> findStudentOrderByFirstNameAsc()
	{
		return studentRepository.findFirstByOrderByFirstNameAsc().stream()
				.map(s -> new StudentData(s.firstName,s.lastName)).collect(Collectors.toList());
	}
/*
 * the Below Methods Denotes the Student in last 3 Days
*/
	public List<DocDate> findTheStudentsCreatedInLast3Days()
	{
		 LocalDate localDate=LocalDate.now();
		return studentRepository.findByCreatedDateGreaterThanEqual(localDate.minusDays(-3)).stream()
				  .map(s -> new DocDate(s.firstName,s.lastName,s.createdDate.toString())).collect(Collectors.toList());
	}
	
	public List<DocDate> findStudentsCreatedInLast3Days()
	{
		 Instant date=Instant.now();
		return studentRepository.findByCreatedDateGreaterThanEqual(date.minusSeconds(72*3600)).stream()
				  .map(s -> new DocDate(s.firstName,s.lastName,s.createdDate.toString())).collect(Collectors.toList());
	}	

	public List<DocDate> findTheDocsCreatedInLast10Hours()
	{
		  Instant date=Instant.now();
		  return studentRepository.findByCreatedDateGreaterThanEqual(date.minusSeconds(10*3600)).stream()
				  .map(s -> new DocDate(s.firstName,s.lastName,s.createdDate.toString())).collect(Collectors.toList());
	}
}