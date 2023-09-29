package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Career;
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
			var rows = repository.getStudentByNumberOfLibrety(number);
			return rows.stream()
					.map(row -> new DTOStudent(row.getFullname(), row.getAge(), row.getNumberOfLibrety(), row.getCity()))
						.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentsBySimpleOrdering() throws Exception {
		try {
			var rows = repository.getStudentsBySimpleOrdering();
			return rows.stream()
					.map(row -> new DTOStudent(row.getFullname(), row.getAge(), row.getNumberOfLibrety(), row.getCity()))
						.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentsByGenre(String genre) throws Exception {
		try {
			var rows = repository.getStudentsByGenre(genre);
			return rows.stream()
					.map(row -> new DTOStudent(row.getFullname(), row.getAge(), row.getNumberOfLibrety(), row.getCity()))
						.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<DTOStudent> getStudentsByCarrerCity(Career car, String city) throws Exception {
		try {
			var rows = repository.getStudentsByCarrerCity(car, city);
			return rows.stream()
					.map(row -> new DTOStudent(row.getFullname(), row.getAge(), row.getNumberOfLibrety(), row.getCity()))
						.collect(Collectors.toList());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
