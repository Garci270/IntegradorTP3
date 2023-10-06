package com.example.demo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DTOCareerRequest {

	@NotNull (message = "idCareer shouldn't be null")
	private int idCareer;
	@NotNull (message = "name shouldn't be null")
	@NotEmpty (message = "name shouldn't be empty")
	private String name;
	
	public DTOCareerRequest(int idCareer, String name) {
		super();
		this.idCareer = idCareer;
		this.name = name;
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
