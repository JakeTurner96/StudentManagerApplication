package com.jake.StudentManager.repository;

import com.jake.StudentManager.pojo.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query(value = "SELECT * FROM STUDENT WHERE NAME LIKE  :letter%", nativeQuery = true)
    Set<Student> findAllStudentsByLetter(@Param("letter") String letter);

}
