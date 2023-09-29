package com.example.demo.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.model.StudentHistory;
import com.example.demo.repository.StudentHistoryRepository;

import jakarta.transaction.Transactional;

@Service("studentHistoryService")
public class StudentHistoryService {

	@Autowired
	private StudentHistoryRepository repository;
	
	@Transactional
	public StudentHistory save(Career career, Student student) throws Exception {
		try {
			Date currentDate = new Date(System.currentTimeMillis());
			StudentHistory studentHistory = new StudentHistory(student, career, currentDate, null);
			return repository.save(studentHistory);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
