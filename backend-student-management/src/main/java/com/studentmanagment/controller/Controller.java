package com.studentmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagment.entity.Student;
import com.studentmanagment.service.StudentService;

@RestController
@RequestMapping("/students")
public class Controller 
{
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	/** Creates the student */
	
	
	/** Edits the student */
	
	
	/** Delete the students */
	
	
	/** Get all students by name */
	@GetMapping("/getAllStudentsByName/{name}")
	public List<Student> getAllStudentsByName(@PathVariable String name)
	{
		return studentService.getAllStudentsByName(name);
	}
}
