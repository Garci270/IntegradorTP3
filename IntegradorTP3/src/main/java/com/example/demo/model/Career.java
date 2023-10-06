package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties(value = {"students"})
public class Career {
	@Id
	private int idCareer;
	@Column(nullable=false)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "career")
	private List<StudentHistory> students;
	
	public Career() {
		// TODO Auto-generated constructor stub
	}

	public Career(int idCareer,String name) {
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
			Career otro = (Career) obj;
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