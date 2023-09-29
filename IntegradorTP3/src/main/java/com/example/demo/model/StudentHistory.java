package com.example.demo.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class StudentHistory implements Serializable {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idStudent")
	private Student student;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCareer")
	private Career career;
	@Column(nullable = false)
	private Date inscriptionDate;
	@Column(nullable = true)
	private Date egressDate;
	
	public StudentHistory() {
		// TODO Auto-generated constructor stub
	}

	public StudentHistory(Student student, Career career, Date inscriptionDate, Date egressDate) {
		super();
		this.student = student;
		this.career = career;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Date getEgressDate() {
		return egressDate;
	}

	public void setEgressDate(Date egressDate) {
		this.egressDate = egressDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Date getInscription() {
		return inscriptionDate;
	}

	public void setInscription(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			StudentHistory otro = (StudentHistory) obj;
			return this.getStudent().equals(otro.getStudent()) && this.getCareer().equals(otro.getCareer());
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return student.getIdStudent();
	}
	
}
