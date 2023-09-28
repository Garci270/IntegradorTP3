package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentController {
	
	@Qualifier("studentRepository")
	@Autowired(required = true)
	private final StudentRepository repository;
	
	
	public StudentController(@Qualifier("studentRepository")StudentRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/")
	public Iterable<Student> getStudents(){
		return repository.findAll();
	}

	@PostMapping("/")
	public void saveStudent(@RequestBody Student student) {
		this.repository.save(student);
	}
	
	@GetMapping("/librety/{number}")
	public Iterable<DTOStudent> getStudentByNumberOfLibrety(@PathVariable int number) {
		return repository.getStudentByNumberOfLibrety(number);
	}

	
	@GetMapping("/byLastname")
	public List<DTOStudent> getStudentsBySimpleOrdering(){
		return repository.getStudentsBySimpleOrdering();
	}
	
	@GetMapping("/genre/{genre}")
	public List<DTOStudent> getStudentsByGenre(@PathVariable String genre){
		return repository.getStudentsByGenre(genre);
	}
}

