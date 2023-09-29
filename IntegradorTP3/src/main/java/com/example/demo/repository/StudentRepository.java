package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Career;
import com.example.demo.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.numberOfLibrety = :number")
	public Iterable<DTOStudent> getStudentByNumberOfLibrety(long number);

	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s ORDER BY s.lastname")
	public List<DTOStudent> getStudentsBySimpleOrdering();
	
	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.genre = :genre")
	public List<DTOStudent> getStudentsByGenre(String genre);
	
	@Query("SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s JOIN s.careers c WHERE c.career = :car AND s.residenceCity= :city")
	public List<DTOStudent> getStudentsByCarrerCity(Career car, String city);
}
