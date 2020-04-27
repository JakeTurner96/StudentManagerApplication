package com.jake.StudentManager.repository;

import com.jake.StudentManager.pojo.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Integer>{

}
