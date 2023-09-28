package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Carrer;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepositoryImpl;

public class StudentService {
	private static StudentService instance;
	private StudentRepositoryImpl impl;
	
	private StudentService() {
		 this.impl = StudentRepositoryImpl.getInstance();
	}
	
	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}
	
	public void insertStudent(Student student) {
		this.impl.insertStudent(student);
	}
	public List<DTOStudent> getStudentsBySimpleOrdering(){
		return this.impl.getStudentsBySimpleOrdering();
	}
	public DTOStudent getStudentByNumberOfLibrety(long number) {
		return this.impl.getStudentByNumberOfLibrety(number);
	}
	
	public List<DTOStudent> getStudentsByGenre(String genre){
		return this.impl.getStudentsByGenre(genre);
	}

	public List<DTOStudent> getStudentsByCareerCity(Carrer car, String city){
		return this.impl.getStudentsByCarrerCity(car, city);
	}
}
