package com.uvik.entity;

import java.time.Instant;

import javax.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student 
{
	@Id
	public ObjectId id;
	public String firstName;
	public String lastName;
	public String schoolName;
	@CreatedDate
	public Instant createdDate;	
}