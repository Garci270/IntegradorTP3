package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;



@RestController
@RequestMapping("student")
public class StudentController {
	
	@Qualifier("studentService")
	@Autowired(required = true)
	private final StudentService service;

    
	public StudentController(@Qualifier("studentService")StudentService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getStudents() {
		try {
			return ResponseEntity.ok(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		try {
			return ResponseEntity.ok(service.save(student));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error: Failed to save");
		}
	}
	
	@GetMapping("/librety/{number}")
	public ResponseEntity<?> getStudentByNumberOfLibrety(@PathVariable int number) {
		try {
			return ResponseEntity.ok(service.getStudentByNumberOfLibrety(number));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}

	
	@GetMapping("/byLastname")
	public ResponseEntity<?> getStudentsBySimpleOrdering() {
		try {
			return ResponseEntity.ok(service.getStudentsBySimpleOrdering());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}
	
	@GetMapping("/genre/{genre}")
	public ResponseEntity<?> getStudentsByGenre(@PathVariable String genre) {
		try {
			return ResponseEntity.ok(service.getStudentsByGenre(genre));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Not found");
		}
	}
}

