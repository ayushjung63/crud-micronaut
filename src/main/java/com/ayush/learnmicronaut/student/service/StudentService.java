package com.ayush.learnmicronaut.student.service;

import com.ayush.learnmicronaut.student.entity.Student;

import java.util.List;

public interface StudentService {
    Integer save(Student student);
    List<Student> getStudentList();
    Student getById(Integer id);
    List<Student> getStudentByFaculty(String faculty);
}
