package com.jake.StudentManager.controller;

import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class  StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getStudentList();
    }

    @RequestMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        return studentService.getStudent(studentID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students/{studentID}")
    public void updateStudent(@RequestBody Student student, @PathVariable int studentID){
        studentService.updateStudent(studentService.getStudent(studentID), student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{studentID}")
    public void deleteStudent(@PathVariable int studentID){
        studentService.removeStudent(studentService.getStudent(studentID));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student/module/{studentID}")
    public void assignModule(@RequestBody Module module, @PathVariable int studentID){
        studentService.getStudent(studentID).setModule(module);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/student/module/{studentID}")
    public void deleteModule(@PathVariable int studentID, int moduleID){

    }



}
