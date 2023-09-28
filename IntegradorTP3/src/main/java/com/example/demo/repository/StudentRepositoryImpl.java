package com.example.demo.repository;

import java.util.List;

import com.example.demo.DTO.DTOStudent;
import com.example.demo.model.Carrer;
import com.example.demo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class StudentRepositoryImpl implements StudentRepository {
	private static StudentRepositoryImpl instance;
	private EntityManager em;

	private StudentRepositoryImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		this.em = emf.createEntityManager();
	}
	
	public static StudentRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new StudentRepositoryImpl();
		}
		return instance;
	}

	// DAR DE ALTA UN ESTUDIANTE
	@Override
	public void insertStudent(Student student) {
		try {
			em.getTransaction().begin();
			if (!em.contains(student)) {
				em.persist(student);
			} else {
				em.merge(student);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// RECUPERAR UN ESTUDIANTE POR NÃšMERO DE LIBRETA UNIVERSITARIA
	@Override
	public DTOStudent getStudentByNumberOfLibrety(long number) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.numberOfLibrety = ?1";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, number);
			DTOStudent stu = query.getSingleResult();
			em.getTransaction().commit();
			return stu;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// RECUPERAR TODOS LOS ESTUDIANTES Y ESTABLECER UN CRITERIO DE ORDENAMIENTO
	// SIMPLE (LASTNAME)
	@Override
	public List<DTOStudent> getStudentsBySimpleOrdering() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s ORDER BY s.lastname";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<DTOStudent> getStudentsByGenre(String genre) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s WHERE s.genre = ?1";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, genre);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	//RECUPERAR LOS ESTUDIANTES DE UNA DETERMINADA CARRERA, FILTRADO POR CIUDAD DE RESIDENCIA
	@Override
	public List<DTOStudent> getStudentsByCarrerCity(Carrer car, String city) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety, s.residenceCity) FROM Student s JOIN s.careers c WHERE c.career = ?1 AND s.residenceCity=?2";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, car);
			query.setParameter(2, city);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			System.out.println("Career: "+car.getName()+", City: "+city);
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
