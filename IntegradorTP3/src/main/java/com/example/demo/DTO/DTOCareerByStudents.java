package com.example.demo.DTO;

public class DTOCareerByStudents {
	private int idCareer;
	private String name;
	private long amountStudents;
	
	
	public DTOCareerByStudents() {
		super();		
	}
	
	public DTOCareerByStudents(int idCareer, String name, long amountStudents) {
		super();
		this.idCareer = idCareer;
		this.name = name;
		this.amountStudents = amountStudents;
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


	public long getAmountStudents() {
		return amountStudents;
	}


	public void setAmountStudents(long amountStudents) {
		this.amountStudents = amountStudents;
	}


	@Override
	public String toString() {
		return "\n Career: "+this.name+ ", Number of students: "+this.amountStudents;
	}
	

}
