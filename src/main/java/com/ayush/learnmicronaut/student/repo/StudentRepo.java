package com.ayush.learnmicronaut.student.repo;

import com.ayush.learnmicronaut.student.entity.Student;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.repository.CrudRepository;
import jakarta.inject.Singleton;

import java.util.List;

@Repository
@Singleton
public interface StudentRepo extends CrudRepository<Student, Integer> {

    @Query(
            nativeQuery = true,
            value = "select * from student where faculty = :faculty"
    )
    List<Student> findListByFaculty(String faculty);
}
