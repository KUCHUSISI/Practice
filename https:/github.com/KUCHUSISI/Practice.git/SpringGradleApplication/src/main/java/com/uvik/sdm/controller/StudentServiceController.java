package com.uvik.sdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uvik.api.beans.DocDate;
import com.uvik.api.beans.SNames;
import com.uvik.api.beans.StudentDetails;
import com.uvik.api.beans.StudentData;
import com.uvik.entity.Student;
import com.uvik.sdm.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping(path = "/student")
public class StudentServiceController 
{
	@Autowired(required = true)
	StudentService studentService;

	@GetMapping("/fetchByFirstName/{firstName}")
	public SNames getStudentByFirstName(@PathVariable("firstName") String firstName)
	{
		return studentService.findStudentByFirstName(firstName);
	}
	
	@PostMapping("/insertData")
	public Student saveStudentData(@RequestBody Student model)
	{
		return studentService.insertStudentData(model);
	}
	@GetMapping("/fetchTheLatestDocumentByDate")
	public Student findTheLatestDocumentByDate()
	{
		return studentService.findTheLatestDocumentByDate();
	}
	
	@GetMapping("/fetchTop10StudentDeatils")
	public List<SNames> findTop10StudentDeatils()
	{
		return studentService.findTop10StudentDetails();
	}

	@GetMapping("/fetchFirstOrderByFirstNameDesc")
	public List<StudentData> findFirstStudentOrderByFirstNameDesc()
	{
		return studentService.findStudentOrderByFirstNameDesc();
	}

	@GetMapping("/fetchFirstByOrderByFirstNameAsc")
	public List<StudentData> findFirstStudentOrderByFirstNameAsc()
	{
		return studentService.findStudentOrderByFirstNameAsc();
	}

	@GetMapping("/fetchByFirstnameStartingWith/{A}")
	public List<StudentDetails> findByFirstnameStartingWith(@PathVariable("A") String A)
	{
		return studentService.findStudentsHavingNameWithCharacters(A);
	}

	@GetMapping("/fetchCreatedInLast10Hrs")
	public List<DocDate> getDocumentsCreatedinLast10Hrs()
	{
		return studentService.findTheDocsCreatedInLast10Hours();
	}
	
	@GetMapping("/fetchCreatedInLast3Days")
	public List<DocDate> GetDocumentsCreatedInLast3Days()
	{
		return studentService.findStudentsCreatedInLast3Days();
	}
	
	@GetMapping("/fetchCreatedInLast72Hours")
	public List<DocDate> findTheStudentsCreatedInLast72Hours()
	{
		return studentService.findStudentsCreatedInLast3Days();
	}
}