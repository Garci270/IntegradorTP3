package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query("SELECT s FROM Student s WHERE s.numberOfLibrety = :number")
	public Optional<Student> getStudentByNumberOfLibrety(long number);

	@Query("SELECT s FROM Student s ORDER BY s.lastname")
	public List<Student> getStudentsBySimpleOrdering();
	
	@Query("SELECT s FROM Student s WHERE s.genre = :genre")
	public List<Student> getStudentsByGenre(String genre);
	
	@Query("SELECT s FROM Student s JOIN s.careers c WHERE c.career.idCareer = :car AND s.residenceCity= :city")
	public List<Student> getStudentsByCareerCity(long car, String city);

}
