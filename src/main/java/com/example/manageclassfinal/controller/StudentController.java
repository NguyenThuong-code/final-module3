package com.example.manageclassfinal.controller;

import com.example.manageclassfinal.model.Student;
import com.example.manageclassfinal.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("/create-student")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }
    @PostMapping("/create-student")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView= new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("message", "New student created successfully");
        return modelAndView;
    }
}
