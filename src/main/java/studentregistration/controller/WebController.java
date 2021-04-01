/**
 * @author Daniel - dcdelima
 * CIS 175 - Spring 2021
 * Mar 31, 2021
 */
package studentregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import studentregistration.beans.Student;
import studentregistration.repository.StudentRepository;

@Controller
public class WebController  {
	
	@Autowired
	StudentRepository studentRepository;

	@GetMapping({"/","viewStudents" })
	public String viewAllStudents(Model model) { 
		if(studentRepository.findAll().isEmpty()) {
			return addNewStudent(model); 
		}
		model.addAttribute("students", studentRepository.findAll());
		return "results";
	}


	@GetMapping("/insertNewStudent")
	public String addNewStudent(Model model) { 
		Student student = new Student();
		model.addAttribute("newStudent", student); 
		return "input";
	}
	

	@PostMapping("/insertNewStudent")
	public String addNewStudent(@ModelAttribute Student student, Model model) {
		studentRepository.save(student);
		return viewAllStudents(model); 
	}


	@GetMapping("/edit/{studentId}")
	public String showUpdateStudent(@PathVariable("studentId") long id, Model model) {
		Student student = studentRepository.findById(id).orElse(null);
		model.addAttribute("newStudent", student); 
		return "input";
	}

	@PostMapping("/update/{studentId}")
	public String reviseStudent(Student student, Model model) { 
		studentRepository.save(student);
		return viewAllStudents(model); 
	}

	@GetMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable("studentId") long id, Model model) {
		Student student = studentRepository.findById(id).orElse(null); 
		studentRepository.delete(student);
		return viewAllStudents(model);
	}

}
