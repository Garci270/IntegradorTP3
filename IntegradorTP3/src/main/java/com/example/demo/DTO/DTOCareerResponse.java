package com.example.demo.DTO;

import com.example.demo.model.Career;

public class DTOCareerResponse {
	private int idCareer;
	private String name;
	
	public DTOCareerResponse() {
		
	}
	
	public DTOCareerResponse(Career career) {
		this.idCareer = career.getIdCareer();
		this.name = career.getName();
	}

	public int getIdCareer() {
		return idCareer;
	}

	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
