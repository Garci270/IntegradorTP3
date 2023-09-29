package com.example.demo.DTO;

import com.example.demo.model.Student;

public class DTOStudent {
	private String fullname;
	private int age;
	private long numberOfLibrety;
	private String city;
	
	public DTOStudent() {
		
	}
	
	public DTOStudent(Student student) {
		this.fullname = student.getNames() + " " + student.getLastname();
		this.age = student.getAge();
		this.numberOfLibrety = student.getNumberOfLibrety();
		this.city = student.getResidenceCity();
	}
	
	public DTOStudent(String fullname, int age, long numberOfLibrety, String city) {
		this.fullname = fullname;
		this.age = age;
		this.numberOfLibrety = numberOfLibrety;
		this.city = city;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getNumberOfLibrety() {
		return numberOfLibrety;
	}

	public void setNumberOfLibrety(long numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "\n [Fullname: "+this.fullname+
				", Age: "+this.age+
				", Number of librety: "+this.numberOfLibrety +
				", City: "+this.city+"]";
	}
}
