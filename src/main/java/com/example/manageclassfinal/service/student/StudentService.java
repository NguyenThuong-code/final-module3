package com.example.manageclassfinal.service.student;

import com.example.manageclassfinal.model.Student;
import com.example.manageclassfinal.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements  IStudentService{
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll(){
        return studentRepository.findAll();
    }
    @Override
    public Optional<Student> findById(Long id){
        return  studentRepository.findById(id);
    }
    @Override
    public void save(Student student){
        studentRepository.save(student);
    }
    @Override
    public void remove(Long id){
        studentRepository.findById(id);
    }
}
