package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentErrorResponse;
import com.example.demo.error.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	List<Student> students;

	@PostConstruct
	public void init(){
		students = new ArrayList<>();
		students.add(new Student("Jas", "Fasola"));
		students.add(new Student("Jan","Kowalski"));
	}


	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){

		if(studentId>=students.size() || studentId<0){
			throw new StudentNotFoundException("Student id not found: "+ studentId);
		}

        return students.get(studentId);
	}


}
