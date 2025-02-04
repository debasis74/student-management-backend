package com.studentmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.studentmanagment.entity.Student;
import com.studentmanagment.service.StudentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getAllStudentsByName/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentService.getAllStudentsByName(name);
    }

    /** Creates the student */
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    /** Edits the student */
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

    /** Delete the student */
    @DeleteMapping("/deleteStudents")
    public ResponseEntity<Void> deleteStudent(@RequestBody List<Long> ids) {
        studentService.deleteStudents(ids);
        return ResponseEntity.noContent().build();
    }

    /** Delete all the students */
    @DeleteMapping("/deleteAllStudents")
    public ResponseEntity<Void> deleteAllStudents() {
        studentService.deleteAllStudents();
        return ResponseEntity.noContent().build();
    }
}
