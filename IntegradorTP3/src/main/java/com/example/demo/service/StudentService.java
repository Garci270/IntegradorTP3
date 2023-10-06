package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.DTOStudentRequest;
import com.example.demo.DTO.DTOStudentResponse;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.validation.Valid;


@Service("studentService")
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Transactional ( readOnly = true )
	public List<DTOStudentResponse> findAll() throws Exception {
		try {
			return repository.findAll().stream().map( DTOStudentResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public DTOStudentResponse save(@Valid DTOStudentRequest dto) throws Exception {
		try {
			Student student = new Student(dto.getIdStudent(), dto.getNames(), dto.getLastname(), dto.getAge(), dto.getGenre(), dto.getDni(), dto.getNumberOfLibrety(), dto.getResidenceCity());
			student = repository.save(student);
			return new DTOStudentResponse(student);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional ( readOnly = true )
	public DTOStudentResponse getStudentByNumberOfLibrety(long number) throws Exception {
		try {
			return repository.getStudentByNumberOfLibrety(number).map( DTOStudentResponse::new ).get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional ( readOnly = true )
	public List<DTOStudentResponse> getStudentsBySimpleOrdering() throws Exception {
		try {
			return repository.getStudentsBySimpleOrdering().stream().map( DTOStudentResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional ( readOnly = true )
	public List<DTOStudentResponse> getStudentsByGenre(String genre) throws Exception {
		try {
			return repository.getStudentsByGenre(genre).stream().map( DTOStudentResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional ( readOnly = true )
	public List<DTOStudentResponse> getStudentsByCareerCity(long car, String city) throws Exception {
		try {
			return repository.getStudentsByCareerCity(car, city).stream().map( DTOStudentResponse::new ).toList();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
