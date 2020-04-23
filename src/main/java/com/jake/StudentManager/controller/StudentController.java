package com.jake.StudentManager.controller;

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

    @RequestMapping("/student/{ID}")
    public Student getStudent(@PathVariable int ID){
        return studentService.getStudent(ID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

}
