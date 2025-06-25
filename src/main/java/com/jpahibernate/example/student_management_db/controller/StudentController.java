package com.jpahibernate.example.student_management_db.controller;

import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student/apis")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return response;
    }

    @GetMapping("/findById/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student =  studentService.findByStudentId(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList = studentService.findAllStudents();
        return studentList;
    }
}