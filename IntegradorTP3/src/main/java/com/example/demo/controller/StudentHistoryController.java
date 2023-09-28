package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrer;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentHistoryRepositoryImpl;

@RestController
@RequestMapping("/studentHistory")
public class StudentHistoryController {
	
	 @Autowired(required = true)
	 private StudentHistoryRepositoryImpl studentHistory;
	 
	 @PostMapping("/")
	 public void insertStudentToCareer(@RequestBody Carrer carrer, Student student) {
		 studentHistory.insertStudentToCareer(carrer, student);
	 }
	 
}
