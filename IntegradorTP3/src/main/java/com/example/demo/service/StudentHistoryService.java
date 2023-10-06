package com.example.demo.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DTOEnroll;
import com.example.demo.DTO.DTOStudentHistoryResponse;
import com.example.demo.model.StudentHistory;
import com.example.demo.repository.CareerRepository;
import com.example.demo.repository.StudentHistoryRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service("studentHistoryService")
public class StudentHistoryService {

	@Autowired
	private StudentHistoryRepository repository;
	
	@Autowired
	private StudentRepository repositoryStudent;
	
	@Autowired
	private CareerRepository repositoryCareer;

	@Transactional
	public DTOStudentHistoryResponse save(DTOEnroll dtoEnroll) throws Exception {
		try {
			final var student = this.repositoryStudent.getStudentByNumberOfLibrety(dtoEnroll.getNumberOfLibrety()).get();
			final var career = this.repositoryCareer.getCareerById(dtoEnroll.getIdCareer());
			Date currentDate = new Date(System.currentTimeMillis());
			
			var studentHistory = new StudentHistory(student, career, currentDate, null);
			studentHistory = this.repository.save(studentHistory);
			
			return new DTOStudentHistoryResponse(studentHistory);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
