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

        studentList.add(new Student(1, "Computer Science", "Jake Turner", LocalDate.of(1996, 8, 16)));
        studentList.add(new Student(5, "Veterinary Medicine", "Hannah Tilbury", LocalDate.of(1995, 9, 11)));
        studentList.add(new Student(19, "Business Management", "Adam Robinson", LocalDate.of(1997, 5, 20)));
    }

    public void addStudent(Student student) throws StudentAlreadyExistsException {
        if (!studentExists(student)) {
            studentList.add(student);
        } else {
            throw new StudentAlreadyExistsException("Student already exists!");
        }
    }

    private boolean studentExists(Student student) {
        return studentList.contains(student);
    }

    public void removeStudent(Student student) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            studentList.remove(student);
        }
    }

    public void updateStudent(Student old, Student newS) throws StudentNotFoundException {
        if (!studentExists(old)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            removeStudent(old);
            addStudent(newS);
        }
    }

    public Student getStudent(int ID){
        return studentList.stream().filter(student -> student.getStudentID() == ID).findFirst().get();
    }

    public void assignModule(Student student, Module module) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            student.setModule(module);
        }
    }

    public void removeModuleAssignment(Student student, Module module) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            student.removeModule(module);
        }
    }

    public List<Student> getStudentList()    {
        return studentList;
    }

}
