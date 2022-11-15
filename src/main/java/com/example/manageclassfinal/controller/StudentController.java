package com.example.manageclassfinal.controller;

import com.example.manageclassfinal.model.Student;
import com.example.manageclassfinal.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    @GetMapping("/students")
    public ModelAndView listStudent(){
        ModelAndView modelAndView =new ModelAndView("/student/list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit-student/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()){
            ModelAndView modelAndView= new ModelAndView("/student/edit");
            modelAndView.addObject("student", student.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error.404");
        }
    }
    @PostMapping("/edit-student")
    public ModelAndView updateStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView= new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        modelAndView.addObject("message","Student Updated Successfully");
        return modelAndView;
    }
    @GetMapping("/delete-student/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Student> student= studentService.findById(id);
        if (student.isPresent()){
            ModelAndView modelAndView= new ModelAndView("/student/delete");
            modelAndView.addObject("student", student.get());
            return  modelAndView;
        }else {
            return new ModelAndView("/error.404");

        }
    }
    @PostMapping("/delete-student")
    public  String deleteStudent(@ModelAttribute("student") Student student){
        studentService.remove(student.getId());
        return "redirect:students";
    }
}
