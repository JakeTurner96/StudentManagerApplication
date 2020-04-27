package com.jake.StudentManager.controller;

import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.services.ModuleService;
import com.jake.StudentManager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    public List<Student> getAllStudents(){
        return studentService.getStudentList();
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        return studentService.getStudent(studentID);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("/students/{studentID}")
    public void updateStudent(@RequestBody Student student, @PathVariable int studentID){
        studentService.updateStudent(studentService.getStudent(studentID), student);
    }

    @DeleteMapping("/students/{studentID}")
    public void deleteStudent(@PathVariable int studentID){
        studentService.removeStudent(studentService.getStudent(studentID));
    }

    //Module operations//
    @PostMapping("/student/module/{studentID}")
    public void assignModule(@RequestBody Module module, @PathVariable int studentID){

    }


//    @GetMapping("/students/modules/{studentID}")
//    public List<Module> getAllModules(@PathVariable int studentID){
//        return studentService.getStudent(studentID).getModuleList();
//    }
//
//    @PutMapping("/student/{studentID}/module/{moduleID}")
//    public void updateModule(@RequestBody Module newModule, @PathVariable int studentID, @PathVariable int moduleID){
//        Student studentTarget = studentService.getStudent(studentID);
//        Module moduleTarget = moduleService.getModule(studentTarget, moduleID);
//        moduleService.updateModule(studentTarget, moduleTarget, newModule);
//    }
//
//    @DeleteMapping("/student/{studentID}/module/{moduleID}")
//    public void deleteModule(@PathVariable int studentID, @PathVariable int moduleID){
//        Student studentTarget = studentService.getStudent(studentID);
//        Module moduleTarget = moduleService.getModule(studentTarget, moduleID);
//        moduleService.removeModule(studentTarget, moduleTarget);
//    }
}
