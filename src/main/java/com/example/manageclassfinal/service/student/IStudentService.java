package com.example.manageclassfinal.service.student;

import com.example.manageclassfinal.model.Student;
import com.example.manageclassfinal.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
Iterable<Student> findAllByName(String name);
}
