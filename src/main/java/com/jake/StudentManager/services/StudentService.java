package com.jake.StudentManager.services;

import com.jake.StudentManager.exceptions.StudentAlreadyExistsException;
import com.jake.StudentManager.exceptions.StudentNotFoundException;
import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> studentList;

    public StudentService(){
        studentList = new ArrayList<>();
        Module testModule = new Module(10, "APIs", "80%", "20%");
        Student testStudent = new Student(1, "Computer Science", "Jake Turner", LocalDate.of(1996, 8, 16));
        testStudent.getModuleList().add(testModule);

        studentList.add(testStudent);
        studentList.add(new Student(2, "Veterinary Medicine", "Hannah Tilbury", LocalDate.of(1995, 9, 11)));
        studentList.add(new Student(3, "Business Management", "Adam Robinson", LocalDate.of(1997, 5, 20)));
    }

    public void addStudent(Student student) throws StudentAlreadyExistsException {
        if (!studentExists(student)) {
            studentList.add(student);
        } else {
            throw new StudentAlreadyExistsException("Student already exists!");
        }
    }

    public void removeStudent(Student student) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            studentList.remove(student);
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
        return studentList.contains(student);
    }

    public Student getStudent(Integer ID){
        return studentList.stream().filter(student -> student.getStudentID().equals(ID)).findFirst().get();
    }

    public List<Student> getStudentList(){
        return studentList;
    }
}
