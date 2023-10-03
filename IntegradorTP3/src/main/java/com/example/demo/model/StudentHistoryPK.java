package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class StudentHistoryPK implements Serializable {
	@Column(name="idCareer")
	private long idCareer;
	@Column(name="idStudent")
	private int idStudent;
	
	public StudentHistoryPK() {
		
	}
	
	public StudentHistoryPK(long idCareer, int idStudent) {
		this.idCareer = idCareer;
		this.idStudent = idStudent;
	}

	public long getIdCareer() {
		return idCareer;
	}

	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			StudentHistoryPK otro = (StudentHistoryPK) obj;
			return this.getIdCareer() == otro.getIdCareer() && this.getIdStudent() == otro.getIdStudent();
		} catch (Exception e) {
			return false;
		}
	}
}
