package com.jake.StudentManager.controller;

import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.services.ModuleService;
import com.jake.StudentManager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class  StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ModuleService moduleService;

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

    @RequestMapping(method = RequestMethod.POST, value = "/student/module/{studentID}")
    public void assignModule(@RequestBody Module module, @PathVariable int studentID){
        moduleService.assignModule(studentService.getStudent(studentID), module);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student/{studentID}/module/{moduleID}")
    public void updateModule(@RequestBody Module newModule, @PathVariable int studentID, @PathVariable int moduleID){
        Student studentTarget = studentService.getStudent(studentID);
        Module moduleTarget = moduleService.getModule(studentTarget, moduleID);
        moduleService.updateModule(studentTarget, moduleTarget, newModule);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/student/{studentID}/module/{moduleID}")
    public void deleteModule(@PathVariable int studentID, @PathVariable int moduleID){
        Student studentTarget = studentService.getStudent(studentID);
        Module moduleTarget = moduleService.getModule(studentTarget, moduleID);
        moduleService.removeModule(studentTarget, moduleTarget);
    }
}
