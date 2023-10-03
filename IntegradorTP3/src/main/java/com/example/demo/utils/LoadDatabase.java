package com.example.demo.utils;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Career;
import com.example.demo.model.Student;
import com.example.demo.repository.CareerRepository;
import com.example.demo.repository.StudentHistoryRepository;
import com.example.demo.repository.StudentRepository;

@Configuration
public class LoadDatabase {
	private static final Logger log = Logger.getLogger(LoadDatabase.class.getName());
	
	@Bean
    CommandLineRunner initDatabase(@Qualifier("careerRepository") CareerRepository careerRepository, @Qualifier("studentRepository") StudentRepository studentRepository, @Qualifier("studentHistoryRepository") StudentHistoryRepository studentHistoryRepository) {
        return args -> {
        	Career c1 = new Career(1, "tudai");
        	Career c2 = new Career(2, "sistemas");
        	log.info("Preloading " +   careerRepository.save(c1));
        	log.info("Preloading " +   careerRepository.save(c2));
        	
        	Student s1 = new Student(1, "juan", "bautista", 25, "male", 1241253, 26422, "tandil");
        	Student s2 = new Student(2, "mariano", "mirinda", 53, "male", 4735235, 75285, "azul");
        	log.info("Preloading " +  studentRepository.save(s1));
        	log.info("Preloading " +  studentRepository.save(s2));
        	
        };
    }
}
