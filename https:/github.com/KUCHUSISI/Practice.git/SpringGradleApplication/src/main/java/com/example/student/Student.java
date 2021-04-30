package com.example.student;

import java.time.Instant;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility =Visibility.ANY)

public class Student 
{
	@Id
	ObjectId id;
	String firstName;
	String lastName;
	String schoolName;
	@CreatedDate
	Instant createdDate;
	
}

