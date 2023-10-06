package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DTOCareerRequest;
import com.example.demo.DTO.DTOSearchCity;
import com.example.demo.service.CareerService;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/career")
public class CareerController {
	
	@Autowired
	private CareerService service;
	
	@Autowired
	private StudentService studentService;
    
	@PostMapping("")
	public ResponseEntity<?> saveCareer(@RequestBody @Valid DTOCareerRequest request) {
		try {
			return ResponseEntity.ok(service.save(request));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: Failed to save");
		}
	}
	@GetMapping("")
	public ResponseEntity<?> getCareers() {
		try {
			return ResponseEntity.ok(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error: Internal server error");
		}
	}
	
	@GetMapping("/byNumberStudents")
	public ResponseEntity<?> getCareersByNumberOfStudents() {
		try {
			return ResponseEntity.ok(service.getCareersByNumberOfStudents());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error: Internal server error");
		}
	}
	
	@GetMapping("/report")
	public ResponseEntity<?> getReportOfCareers() {
		try {
			return ResponseEntity.ok(service.getReportOfCareers());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error: Internal server error");
		}
	}
	
	@GetMapping("/{car}")
	public ResponseEntity<?> getStudentsByCareerCity(@PathVariable int car, DTOSearchCity request) {
		try {
			return ResponseEntity.ok(studentService.getStudentsByCareerCity(car, request.getCity()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error: Internal server error");
		}
	}
	
	

}
