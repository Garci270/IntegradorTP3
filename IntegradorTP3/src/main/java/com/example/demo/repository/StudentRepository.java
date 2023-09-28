package com.example.demo.repository;

import java.util.List;

import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Carrer;
import com.example.demo.model.Student;

public interface StudentRepository {
	public void insertStudent(Student student);
	public List<DTOStudent> getStudentsBySimpleOrdering();
	public DTOStudent getStudentByNumberOfLibrety(long number);
	public List<DTOStudent> getStudentsByGenre(String genre);
	public List<DTOStudent> getStudentsByCarrerCity(Carrer car, String city);
}
