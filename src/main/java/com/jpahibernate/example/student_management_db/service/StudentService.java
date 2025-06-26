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

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id : "+id+" has been deleted successfully!";
    }

    public String updateStudentUsingPut(int id, Student newStudentRequest){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student existingStudent  = findByStudentId(id);
        if(existingStudent!=null){
            // update the student
            studentRepository.save(newStudentRequest);
            return "Student updated successfully!";
        } else{
            return "Student not found to update!";
        }

    }

    public String updateStudentEmailUsingPatch(int id, String newEmail){
        // find student with id
        // if student is present, update it
        // else we cannot update

        Student existingStudent  = findByStudentId(id);
        if(existingStudent!=null){
            // update the student
            existingStudent.setEmail(newEmail);
            studentRepository.save(existingStudent);
            return "Student updated successfully!";
        } else{
            return "Student not found to update!";
        }

    }
}