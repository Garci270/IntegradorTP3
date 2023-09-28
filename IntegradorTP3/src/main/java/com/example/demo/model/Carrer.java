package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrer {
	@Id
	private int idCareer;
	@Column(nullable=false)
	private String name;
	@OneToMany(mappedBy = "career")
	private List<StudentHistory> students;
	
	public Carrer() {
		// TODO Auto-generated constructor stub
	}

	public Carrer(int idCareer,String name) {
		super();
		this.idCareer = idCareer;
		this.name = name;
		this.students = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCareer() {
		return idCareer;
	}

	public List<StudentHistory> getStudents() {
		return students;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Carrer otro = (Carrer) obj;
			return this.getIdCareer() == otro.getIdCareer();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "\nCareer: "+name;
	}
}