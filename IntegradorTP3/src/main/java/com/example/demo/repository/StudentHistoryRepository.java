package com.example.demo.repository;

import com.example.demo.model.Carrer;
import com.example.demo.model.Student;

public interface StudentHistoryRepository {
	public void insertStudentToCareer(Carrer carrer, Student student);
	public void graduateStudent(Student student, Carrer carrer);
}
