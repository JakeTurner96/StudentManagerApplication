package com.jake.StudentManager.services;

import com.jake.StudentManager.exceptions.StudentAlreadyExistsException;
import com.jake.StudentManager.exceptions.StudentNotFoundException;
import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModuleService moduleService;


    public StudentService(){
    }

    public void addStudent(Student student) throws StudentAlreadyExistsException {
        if (!studentExists(student)) {
            studentRepository.save(student);
        } else {
            throw new StudentAlreadyExistsException("Student already exists!");
        }
    }

    public void removeStudent(Student student) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            studentRepository.delete(student);
        }
    }

    public void updateStudent(Student oldStudent, Student newStudent) throws StudentNotFoundException {
        if (!studentExists(oldStudent)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            removeStudent(oldStudent);
            addStudent(newStudent);
        }
    }

    public boolean studentExists(Student student) {
        return studentRepository.existsById(student.getStudentID());
    }

    public Student getStudent(Integer ID){
        return studentRepository.findById(ID).orElse(null);
    }

    public List<Student> getStudentList(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }
}
