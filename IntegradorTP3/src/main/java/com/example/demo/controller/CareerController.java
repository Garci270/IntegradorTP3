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

import com.example.demo.DTO.DTOSearchCity;
import com.example.demo.model.Career;
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
    
	//ACA HAY QUE PASAR UN DTO COMO PARAMETRO PARA EL POST
	@PostMapping("")
	public ResponseEntity<?> saveCareer(@RequestBody @Valid Career career) {
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
	
	@GetMapping("/{car}")
	public ResponseEntity<?> getStudentsByCareerCity(@PathVariable long car, DTOSearchCity request) {
		try {
			return ResponseEntity.ok(studentService.getStudentsByCareerCity(car, request.getCity()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}
	
	

}
