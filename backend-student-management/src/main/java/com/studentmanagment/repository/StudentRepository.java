package com.studentmanagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagment.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByNameContainingIgnoreCaseAndIsDeletedFalse(String name);
    
    List<Student> findAllByIsDeletedFalse();
}
