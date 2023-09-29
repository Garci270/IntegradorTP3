package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
//	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.numberOfLibrety = :number")
	//@Query("SELECT CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity FROM Student s WHERE s.numberOfLibrety = :number")
	@Query("SELECT s FROM Student s WHERE s.numberOfLibrety = :number")
	public List<Student> getStudentByNumberOfLibrety(long number);

//	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s ORDER BY s.lastname")
	//@Query("SELECT CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity FROM Student s ORDER BY s.lastname")
	@Query("SELECT s FROM Student s ORDER BY s.lastname")
	public List<Student> getStudentsBySimpleOrdering();
	
//	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.genre = :genre")
	//@Query("SELECT CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity FROM Student s WHERE s.genre = :genre")
	@Query("SELECT s FROM Student s WHERE s.genre = :genre")
	public List<Student> getStudentsByGenre(String genre);
	
//	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s JOIN s.careers c WHERE c.career = :car AND s.residenceCity= :city")
	//@Query("SELECT CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity FROM Student s JOIN s.careers c WHERE c.career.idCareer = :car AND s.residenceCity= :city")
	@Query("SELECT s FROM Student s JOIN s.careers c WHERE c.career.idCareer = :car AND s.residenceCity= :city")
	public List<Student> getStudentsByCareerCity(int car, String city);
}
