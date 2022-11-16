package com.example.manageclassfinal.repository;

import com.example.manageclassfinal.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends JpaRepository<Classroom, Long> {

}
