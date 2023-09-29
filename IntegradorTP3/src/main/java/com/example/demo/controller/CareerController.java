package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Career;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.CareerService;

@RestController
@RequestMapping("/career")
public class CareerController {
	
	@Autowired
	private CareerService service;
	private StudentRepository student;
	
	@PostMapping("/")
	public ResponseEntity<?> saveCareer(@RequestBody Career career) {
		try {
			return ResponseEntity.ok(service.save(career));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: Failed to save");
		}
	}
	
	@GetMapping("/byNumberStudents")
	public ResponseEntity<?> getCareersByNumberOfStudents() {
		try {
			return ResponseEntity.ok(service.getCareersByNumberOfStudents());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> getReportOfCareers() {
		try {
			return ResponseEntity.ok(service.getReportOfCareers());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}
	
	@GetMapping("/studentsByCity/{car}/{city}")
	public ResponseEntity<?> getStudentsByCareerCity(@PathVariable Career car, String city) {
		try {
			return ResponseEntity.ok(student.getStudentsByCarrerCity(car, city));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}

}
