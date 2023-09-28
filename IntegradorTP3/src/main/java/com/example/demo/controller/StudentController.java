package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepositoryImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired(required = true)
	private StudentRepositoryImpl student;
	
	
	@PostMapping("")
	public void saveStudent(@RequestBody Student student) {
		this.student.insertStudent(student);
	}
	
	@PostMapping("/librety/{number}")
	public DTOStudent getStudentByNumberOfLibrety(@PathVariable int number) {
		return student.getStudentByNumberOfLibrety(number);
	}
	
	@GetMapping("/byLastname")
	public List<DTOStudent> getStudentsBySimpleOrdering(){
		return student.getStudentsBySimpleOrdering();
	}
	
	@GetMapping("/genre/{genre}")
	public List<DTOStudent> getStudentsByGenre(@PathVariable String genre){
		return student.getStudentsByGenre(genre);
	}
}

