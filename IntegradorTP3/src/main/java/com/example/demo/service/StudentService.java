package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service("studentService")
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Transactional
	public List<Student> findAll() throws Exception {
		try {
			return repository.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public Student save(Student student) throws Exception {
		try {
			return repository.save(student);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentByNumberOfLibrety(long number) throws Exception {
		try {
			return repository.getStudentByNumberOfLibrety(number).stream().map( DTOStudent::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentsBySimpleOrdering() throws Exception {
		try {
			return repository.getStudentsBySimpleOrdering().stream().map( DTOStudent::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentsByGenre(String genre) throws Exception {
		try {
			return repository.getStudentsByGenre(genre).stream().map( DTOStudent::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentsByCareerCity(int car, String city) throws Exception {
		try {
			return repository.getStudentsByCareerCity(car, city).stream().map( DTOStudent::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
