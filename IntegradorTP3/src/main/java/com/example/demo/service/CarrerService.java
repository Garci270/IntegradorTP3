package com.example.demo.service;

import com.example.demo.model.Carrer;
import com.example.demo.model.Student;
import com.example.demo.repository.CarrerRepositoryImpl;
import com.example.demo.repository.StudentHistoryRepositoryImpl;

import java.util.List;

import com.example.demo.DTO.DTOCarrerByStudents;
import com.example.demo.DTO.DTOCarrerByYear;

public class CarrerService {
	private static CarrerService instance;
	private CarrerRepositoryImpl impl;
	private StudentHistoryRepositoryImpl impl_student_history;

	private CarrerService() {
		this.impl = CarrerRepositoryImpl.getInstance();
		this.impl_student_history = StudentHistoryRepositoryImpl.getInstance();
	}
	
	public static CarrerService getInstance() {
		if (instance == null) {
			instance = new CarrerService();
		}
		return instance;
	}
	
	public void graduateStudent(Student student, Carrer carrer) {
		this.impl_student_history.graduateStudent(student, carrer);
	}
	public void insertStudentToCareer(Carrer carrer, Student student) {
		this.impl_student_history.insertStudentToCareer(carrer, student);
	}
	public void insertCareer(Carrer carrer) {
		this.impl.insertCarrer(carrer);
	}
	public List<DTOCarrerByStudents> getCareersByNumberOfStudents(){
		return this.impl.getCarrersByNumberOfStudents();
	}
	public List<DTOCarrerByYear> getReportOfCareers() {
		return this.impl.getReportOfCarrers();
	}
	
}
