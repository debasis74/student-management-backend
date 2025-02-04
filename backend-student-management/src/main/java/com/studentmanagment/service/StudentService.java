package com.studentmanagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagment.entity.Student;
import com.studentmanagment.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAllByIsDeletedFalse();
    }

    public List<Student> getAllStudentsByName(String name) {
        return studentRepository.findByNameContainingIgnoreCaseAndIsDeletedFalse(name);
    }
    
    @Transactional
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    @Transactional
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent() && !optionalStudent.get().isDeleted()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setAddress(studentDetails.getAddress());
            student.setAge(studentDetails.getAge());
            student.setPhoneNumber(studentDetails.getPhoneNumber());
            student.setStudentClass(studentDetails.getStudentClass());
            return studentRepository.save(student);
        }
        return null;
    }
    
    @Transactional
    public void deleteStudents(List<Long> ids) {
        List<Student> students = studentRepository.findAllById(ids);
        for (Student student : students) {
            student.setDeleted(true);
        }
        studentRepository.saveAll(students);
    }
    
    @Transactional
    public void deleteAllStudents() {
        List<Student> students = studentRepository.findAllByIsDeletedFalse();
        for (Student student : students) {
            student.setDeleted(true);
        }
        studentRepository.saveAll(students);
    }
}
