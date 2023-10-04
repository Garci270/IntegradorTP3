package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class StudentHistoryPK implements Serializable {
	@Column(name="id_career")
	private int idCareer;
	@Column(name="id_student")
	private int idStudent;
	
	public StudentHistoryPK() {
		
	}
	
	public StudentHistoryPK(int idCareer, int idStudent) {
		this.idCareer = idCareer;
		this.idStudent = idStudent;
	}

	public int getIdCareer() {
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
	public int hashCode() {
		return Objects.hash(idCareer, idStudent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentHistoryPK other = (StudentHistoryPK) obj;
		return idCareer == other.idCareer && idStudent == other.idStudent;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		try {
//			StudentHistoryPK otro = (StudentHistoryPK) obj;
//			return this.getIdCareer() == otro.getIdCareer() && this.getIdStudent() == otro.getIdStudent();
//		} catch (Exception e) {
//			return false;
//		}
//	}
}
