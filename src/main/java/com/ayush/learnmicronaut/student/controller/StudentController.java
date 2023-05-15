package com.ayush.learnmicronaut.student.controller;

import com.ayush.learnmicronaut.student.entity.Student;
import com.ayush.learnmicronaut.student.service.StudentService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/api/student")
public class StudentController {
    @Inject
    private  StudentService studentService;

    @Post(value = "/save")
    public Integer saveStudent(@Body Student  student){
        Integer id = studentService.save(student);
        return id;
    }

    @Get(value = "/list")
    public List<Student> fetchAllStudent(){
        List<Student> studentList = studentService.getStudentList();
        return studentList;
    }

    @Get(value = "/id/{id}")
    public Student fetchById(@PathVariable("id") Integer id){
        Student student = studentService.getById(id);
        return student;
    }

    @Get()
        public List<Student> fetchByFaculty(@QueryValue String faculty){
        List<Student> students = studentService.getStudentByFaculty(faculty);
        return students;
    }
}
