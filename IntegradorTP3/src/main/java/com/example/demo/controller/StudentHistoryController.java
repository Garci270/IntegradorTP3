package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.service.StudentHistoryService;


@RestController
@RequestMapping("/studentHistory")
public class StudentHistoryController {
	
	 @Autowired(required = true)
	 private StudentHistoryService service;

	    
	 @PostMapping("/")
	 public ResponseEntity<?> insertStudentToCareer(@RequestBody Career carrer, Student student) {
		 try {
			return ResponseEntity.ok(service.save(carrer, student));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: Failed to save");
		}
	 }
	 
}
