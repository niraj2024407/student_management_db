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

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response = studentService.deleteStudentById(id);
        return response;
    }

    @PutMapping("/update/{id}")
    public String updateStudentUsingPut(@PathVariable int id, @RequestBody Student newStudentRequest){
        String response = studentService.updateStudentUsingPut(id,newStudentRequest);
        return response;
    }

    // @RequestParam - only requesting that particular parameter(takes in the form of request parameter query)
    @PatchMapping("/updateEmail/{id}")
    public String updateStudentEmailUsingPatch(@PathVariable int id,@RequestParam String newEmail){
        String response = studentService.updateStudentEmailUsingPatch(id,newEmail);
        return response;
    }
}