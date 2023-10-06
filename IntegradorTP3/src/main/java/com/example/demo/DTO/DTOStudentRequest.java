package com.example.demo.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DTOStudentRequest {
	@NotNull( message = "idStudent shouldn't be null")
	private int idStudent;
	@NotNull( message = "names shouldn't be null")
	@NotEmpty( message = "names shouldn't be empty")
	private String names;
	@NotNull( message = "lastname shouldn't be null")
	@NotEmpty( message = "lastname shouldn't be empty")
	private String lastname;
	@NotNull( message = "age shouldn't be null")
	private int age;
	@NotNull( message = "genre shouldn't be null")
	@NotEmpty( message = "genre shouldn't be empty")
	private String genre;
	@NotNull( message = "dni shouldn't be null")
	private long dni;
	@NotNull( message = "numberOfLibrety shouldn't be null")
	private long numberOfLibrety;
	@NotNull( message = "residenceCity shouldn't be null")
	@NotEmpty( message = "residenceCity shouldn't be empty")
	private String residenceCity;

	public DTOStudentRequest(int idStudent,String names, String lastname, int age, String genre, long dni,long numberOfLibrety, String residenceCity) {
		super();
		this.idStudent = idStudent;
		this.names = names;
		this.lastname = lastname;
		this.age = age;
		this.genre = genre;
		this.dni = dni;
		this.numberOfLibrety = numberOfLibrety;
		this.residenceCity = residenceCity;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public long getNumberOfLibrety() {
		return numberOfLibrety;
	}

	public void setNumberOfLibrety(long numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	
}
