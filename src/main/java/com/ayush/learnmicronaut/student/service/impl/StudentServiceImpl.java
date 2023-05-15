package com.ayush.learnmicronaut.student.service.impl;

import com.ayush.learnmicronaut.student.entity.Student;
import com.ayush.learnmicronaut.student.repo.StudentRepo;
import com.ayush.learnmicronaut.student.service.StudentService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Singleton
public class StudentServiceImpl implements StudentService {
    @Inject
    private  StudentRepo studentRepo;

    @Override
    public Integer save(Student student) {
        Student savedStudent = studentRepo.save(student);
        return savedStudent.getId();
    }

    @Override
    public List<Student> getStudentList() {
        Iterable<Student> all = studentRepo.findAll();
        Iterator<Student> iterator = all.iterator();
        List<Student> studentList=new ArrayList<>();
        while (iterator.hasNext()){
            studentList.add(iterator.next());
        }
        return studentList;
    }

    @Override
    public Student getById(Integer id) {
        return studentRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Student Not Found")
        );
    }

    @Override
    public List<Student> getStudentByFaculty(String faculty) {
        return studentRepo.findListByFaculty(faculty);
    }
}
