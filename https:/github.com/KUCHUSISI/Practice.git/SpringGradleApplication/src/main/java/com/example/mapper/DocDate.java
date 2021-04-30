package com.example.mapper;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility =Visibility.ANY)
public class DocDate
{
	String firstName;
	String lastName;
	Instant createdDate;
}
