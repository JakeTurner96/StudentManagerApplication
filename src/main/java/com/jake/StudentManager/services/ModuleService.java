package com.jake.StudentManager.services;

import com.jake.StudentManager.exceptions.ModuleNotFoundException;
import com.jake.StudentManager.exceptions.StudentNotFoundException;
import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.repository.ModuleRepository;
import com.jake.StudentManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class ModuleService {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModuleRepository moduleRepository;

    public ModuleService() {
    }

    public Module getModule(int moduleID) {
        if (!moduleRepository.existsById(moduleID)) {
            throw new ModuleNotFoundException("Module not found");
        } else {
            return moduleRepository.findById(moduleID).get();
        }
    }

    public Set<Module> getModuleSet() {
        Set<Module> modules = new TreeSet<>();
        moduleRepository.findAll().forEach(modules::add);
        return modules;
    }

    public void assignExistingModule(int studentID, int moduleID) throws StudentNotFoundException  {
        if (!studentService.studentExists(studentService.getStudent(studentID))) {
            throw new StudentNotFoundException("Student could not be found");
        } else {
            Student updatedStudent = studentRepository.findById(studentID).get();
            updatedStudent.getModuleSet().add(getModule(moduleID));
            studentRepository.save(updatedStudent);
        }
    }

    public void assignNewModule(int studentID, Module module) throws StudentNotFoundException {

        moduleRepository.save(module);
        Student updatedStudent = studentRepository.findById(studentID).get();
        assignExistingModule(studentID, module.getModuleID());
        studentRepository.save(updatedStudent);

    }

    public void removeStudentModule(int studentID, int moduleID) throws StudentNotFoundException {
        if (!studentService.studentExists(studentService.getStudent(studentID))) {
            throw new StudentNotFoundException("Student or module could not be found");
        } else {
            Student updatedStudent = studentRepository.findById(studentID).get();
            updatedStudent.getModuleSet().remove(getModule(moduleID));
            studentRepository.save(updatedStudent);
        }
    }
}
