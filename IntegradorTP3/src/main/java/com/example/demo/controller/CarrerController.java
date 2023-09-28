package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DTOCarrerByStudents;
import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Carrer;
import com.example.demo.repository.CarrerRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/career")
public class CarrerController {
	
	@Autowired
	private CarrerRepository carrer;
	private StudentRepository student;
	
	@GetMapping("/byNumberStudents")
	public List<DTOCarrerByStudents> getCareersByNumberOfStudents() {
		return carrer.getCarrersByNumberOfStudents();
	}
	
	
	@GetMapping("/studentsByCity/{car}/{city}")
	public List<DTOStudent> getStudentsByCareerCity(@PathVariable Carrer car, String city) {
		return student.getStudentsByCarrerCity(car, city);
	}

}
