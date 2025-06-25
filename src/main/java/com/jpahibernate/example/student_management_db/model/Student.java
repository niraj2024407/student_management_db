
package com.jpahibernate.example.student_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // it represents that this class is entity or model class which is directly creating the database table or schema
@Table(name="student") // it will create a table inside database
//@Data // it will generate getter setters
public class Student {

    @Id // it is the primary key of the table - it is always unique and it is not null
    @Column(name="id") // it will create a column inside database table
    private int id;

    @Column(name="student_name", nullable = false) // nullable = false - it cannot contain null value
    private String name;

    @Column(name="email", nullable = false, unique=true) // unique=true - it cannot be duplicated
    private String email;

    @Column(name="dob", nullable = false)
    private String dob;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="grade", nullable = false)
    private String grade;

    @Column(name="address", nullable = false)
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
