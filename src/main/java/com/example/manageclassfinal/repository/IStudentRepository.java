package com.example.manageclassfinal.repository;

import com.example.manageclassfinal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
   Iterable<Student> findAllByNameContaining(String name);
}
