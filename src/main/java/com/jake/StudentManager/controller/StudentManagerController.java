package com.jake.StudentManager.controller;

import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.services.ModuleService;
import com.jake.StudentManager.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StudentManagerController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ModuleService moduleService;

    //Student operations//
    @GetMapping("/students")
    public Set<Student> getAllStudents() {
        return studentService.getStudentSet();
    }

    @GetMapping("/students/get/{studentID}")
    public Student getStudent(@PathVariable int studentID) {
        return studentService.getStudent(studentID);
    }

    @GetMapping("/students/{letter}")
    public Set<Student> getByLetter(@PathVariable String letter) {
        return studentService.getStudentsByLetter(letter);
    }

    @GetMapping("/students/get/exam")
    public List<Student> getStudentByExamWeight() {
        return studentService.getStudentByExamWeight();
    }

    @PostMapping("/students/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/students/update/{studentID}")
    public void updateStudent(@RequestBody Student student, @PathVariable int studentID) {
        studentService.updateStudent(studentService.getStudent(studentID), student);
    }

    @DeleteMapping("/students/delete/{studentID}")
    public void deleteStudent(@PathVariable int studentID) {
        studentService.removeStudent(studentService.getStudent(studentID));
    }

    //Module operations//
    @GetMapping("/students/get/module")
    public Set<Module> getAllModules() {
        return moduleService.getModuleSet();
    }

    @GetMapping("/students/get/module/{moduleID}")
    public Module getModule(@PathVariable int moduleID) {
        return moduleService.getModule(moduleID);
    }

    @PostMapping("/students/{studentID}/module/{moduleID}/assign")
    public void assignExistingModule(@PathVariable int studentID, @PathVariable int moduleID) {
        moduleService.assignExistingModule(studentID, moduleID);
    }

    @PostMapping("/students/{studentID}/module/assign")
    public void assignNewModule(@RequestBody Module module, @PathVariable int studentID) {
        moduleService.assignNewModule(studentID, module);
    }

    @DeleteMapping("/students/{studentID}/module/{moduleID}")
    public void removeStudentModule(@PathVariable int studentID, @PathVariable int moduleID) {
        moduleService.removeStudentModule(studentID, moduleID);
    }

}
