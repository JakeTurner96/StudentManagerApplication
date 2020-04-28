package com.jake.StudentManager.controller;

import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.services.ModuleService;
import com.jake.StudentManager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentManagerController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ModuleService moduleService;

    //Student operations//
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getStudentList();
    }

    @GetMapping("/student/get/{studentID}")
    public Student getStudent(@PathVariable int studentID) {
        return studentService.getStudent(studentID);
    }

    @GetMapping("/students/{letter}")
    public List<Student> getByLetter(@PathVariable String letter) {
        return studentService.getStudentsByLetter(letter);
    }

    @PostMapping("/students/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/student/update/{studentID}")
    public void updateStudent(@RequestBody Student student, @PathVariable int studentID) {
        studentService.updateStudent(studentService.getStudent(studentID), student);
    }

    @DeleteMapping("/students/delete/{studentID}")
    public void deleteStudent(@PathVariable int studentID) {
        studentService.removeStudent(studentService.getStudent(studentID));
    }

    @GetMapping("/student/get")
    public List<Student> getStudentByExamWeight() {
        return studentService.getStudentByExamWeight();
    }

    //Module operations//
    @PostMapping("/student/module/assign/{studentID}")
    public void assignModule(@RequestBody Module module, @PathVariable int studentID) {
        moduleService.assignModule(studentService.getStudent(studentID), module);
    }

    @DeleteMapping("/students/{studentID}/module/{moduleID}")
    public void deleteModule(@PathVariable int studentID, @PathVariable int moduleID) {
        Student targetStudent = studentService.getStudent(studentID);
        Module targetModule = moduleService.getModule(targetStudent, moduleID);
        moduleService.removeModule(targetStudent, targetModule);
    }
}
