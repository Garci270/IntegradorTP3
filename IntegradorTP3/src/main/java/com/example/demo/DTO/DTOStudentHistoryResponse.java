package com.example.demo.DTO;

import java.sql.Date;

import com.example.demo.model.StudentHistory;

public class DTOStudentHistoryResponse {
	private DTOStudentResponse student;
	private DTOCareerResponse career;
	private Date inscriptionDate;
	
	public DTOStudentHistoryResponse() {
		
	}
	
	public DTOStudentHistoryResponse(StudentHistory studentHistory) {
		this.student = new DTOStudentResponse(studentHistory.getStudent());
		this.career = new DTOCareerResponse(studentHistory.getCareer());
		this.inscriptionDate = studentHistory.getInscriptionDate();
	}

	public DTOStudentResponse getStudent() {
		return student;
	}

	public void setStudent(DTOStudentResponse student) {
		this.student = student;
	}

	public DTOCareerResponse getCareer() {
		return career;
	}

	public void setCareer(DTOCareerResponse career) {
		this.career = career;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
}
