/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 31, 2021
 */
package studentregistration.controller;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
//import studentregistration.beans.Student;
//import studentregistration.repository.StudentRepository;

import studentregistration.beans.Student;
import studentregistration.repository.StudentRepository;

@Configuration
public class StudentConfiguration {
	

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args->{
			Student ali = new Student(
					"Ali",
					"Abdaal",
					"Aabdaal.@email.com",
					"Business Information Systems",
					3.8
			);
			
			Student ken = new Student(
					"Ken",
					"Masters",
					"kmasters@email.com",
					"Computer Information Systems",
					3.5
			);
			
			ArrayList<Student> stl = new ArrayList<>();
			stl.add(ali);
			stl.add(ken);
			
			studentRepository.saveAll(stl);
		};
	}

}
