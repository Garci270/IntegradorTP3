package com.example.demo.DTO;



public class DTOEnroll {
	private long numberOfLibrety;
	private int idCareer;
	
	
	public DTOEnroll(long number, int idCareer) {
		this.numberOfLibrety = number;
		this.idCareer = idCareer;		
		
	}


	public long getNumberOfLibrety() {
		return numberOfLibrety;
	}


	public void setNumberOfLibrety(long numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}


	public int getIdCareer() {
		return idCareer;
	}


	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}



}
