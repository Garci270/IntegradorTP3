package com.example.demo.DTO;

public class DTOCareer {

	private int idCareer;
	private String name;
	
	
	public DTOCareer(int idCareer, String name) {
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
