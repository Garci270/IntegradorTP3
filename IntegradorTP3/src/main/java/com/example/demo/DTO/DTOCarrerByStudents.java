package com.example.demo.DTO;

public class DTOCarrerByStudents {
	private String name;
	private long amountStudents;
	
	
	public DTOCarrerByStudents() {
		super();		
	}
	
	public DTOCarrerByStudents(String name, long amountStudents) {
		super();
		this.name = name;
		this.amountStudents = amountStudents;
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
