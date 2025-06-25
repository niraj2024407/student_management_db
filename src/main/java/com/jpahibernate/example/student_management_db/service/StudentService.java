package com.jpahibernate.example.student_management_db.service;

import com.jpahibernate.example.student_management_db.StudentManagementDbApplication;
import com.jpahibernate.example.student_management_db.model.Student;
import com.jpahibernate.example.student_management_db.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // it is a service class and it contains the business logic
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student saved successfully!";
    }

    public Student findByStudentId(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            return studentOptional.get();
        } else {
            return null;
        }
    }

    public List<Student> findAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
}