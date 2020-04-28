package com.jake.StudentManager.services;

import com.jake.StudentManager.exceptions.StudentNotFoundException;
import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleService {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    public ModuleService() {
    }

    public void assignModule(Student student, Module module) throws StudentNotFoundException {
        if (!studentService.studentExists(student)) {
            throw new StudentNotFoundException("Student could not be found");
        } else {
            Student updatedStudent = studentRepository.findById(student.getStudentID()).get();
            updatedStudent.getModuleList().add(module);
            studentRepository.save(updatedStudent);
        }
    }

    public void removeModule(Student student, Module module) throws StudentNotFoundException {
        if (!studentService.studentExists(student)) {
            throw new StudentNotFoundException("Student or module could not be found");
        } else {
            Student updatedStudent = studentRepository.findById(student.getStudentID()).get();
            updatedStudent.getModuleList().remove(module);
            studentRepository.save(updatedStudent);
        }
    }

    public boolean moduleExists(Student student, Module module) {
        return student.getModuleList().contains(module);
    }

    public Module getModule(Student student, Integer moduleID) {
        return student.getModuleList().stream().filter(module -> module.getModuleID().equals(moduleID)).findFirst().get();
    }

//    public void updateModule(Student student, Module oldModule, Module newModule){
//        if (!studentService.studentExists(student) || !moduleExists(student, oldModule)) {
//            throw new StudentNotFoundException("Student or module could not be found");
//        } else {
//
//        }
//    }
}
