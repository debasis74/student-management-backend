package com.studentmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagment.entity.Student;
import com.studentmanagment.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	/** Gets the list of all the students */
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	/** Creates the student */
	
	
	/** Edits the student */
	
	
	/** Delete the students */
	
	
	/** Get all students by name */
	public List<Student> getAllStudentsByName(String name){
		return studentRepository.findAllByName(name);
	}
	
}
