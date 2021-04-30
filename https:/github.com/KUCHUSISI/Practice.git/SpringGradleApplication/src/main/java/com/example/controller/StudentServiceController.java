package com.example.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.DocDate;
import com.example.mapper.Pojo;
import com.example.mapper.SData;
import com.example.mapper.StudentDetails;
import com.example.mapper.StudentPojo;
import com.example.service.StudentService;
import com.example.student.Student;

import ch.qos.logback.classic.Logger;
@CrossOrigin
@RestController
public class StudentServiceController 
{
	@Autowired(required = true)
	StudentService studentService;
	Logger logger=(Logger) LoggerFactory.getLogger(StudentServiceController.class);

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/getStudentByFirstName/{firstName}")
	public SData getStudentByFirstName(@PathVariable("firstName") String firstName)
	{
		return studentService.findStudentByFirstName(firstName);
	}
	
	@PostMapping("/insertStudentData")
	public Student saveStudentData(@RequestBody Student model)
	{
		return studentService.insertStudentData(model);
	}
	@GetMapping("/findTheLatestDocumentByDate")
	public Student findTheLatestDocumentByDate()
	{
		return studentService.findTheLatestDocumentByDate();
	}
		
	@GetMapping("/findTop10StudentDeatils")
	public List<Pojo> findTop10StudentDeatils()
	{
		return studentService.findTop10StudentDeatils();
	}
	
	@GetMapping("/findFirstOrderByFirstNameDesc")
	public List<StudentPojo> findFirstStudentOrderByFirstNameDesc()
	{
		return studentService.findStudentOrderByFirstNameDesc();
	}
	
	@GetMapping("/findFirstByOrderByFirstNameAsc")
	public List<StudentPojo> findFirstStudentOrderByFirstNameAsc()
	{
		return studentService.findStudentOrderByFirstNameAsc();
	}
	
	@GetMapping("/findByFirstnameStartingWith/{A}")
	public List<StudentDetails> findByFirstnameStartingWith(@PathVariable("A") String A)
	{
		return studentService.findStudentsHavingNameWithCharacters(A);
	}
	
	@GetMapping("/GetDocumentsCreatedInLast10Hrs")
	public List<DocDate> getDocumentsCreatedinLast10Hrs()
	{
		return studentService.findTheDocsCreatedInLast10Hours();
	}
	@GetMapping("/GetTheDocsCreatedInLast3Days")
	public List<DocDate> GetDocumentsCreatedInLast3Days()
	{
		return studentService.findTheDocsCreatedInLast3Days();
	}
}