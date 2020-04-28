package com.jake.StudentManager.services;

import com.jake.StudentManager.exceptions.StudentAlreadyExistsException;
import com.jake.StudentManager.exceptions.StudentNotFoundException;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentService implements Comparator<Student> {

    @Autowired
    private StudentRepository studentRepository;

    public StudentService() {
    }

    public Student getStudent(Integer ID) {
        if (!studentRepository.existsById(ID)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            System.out.println(studentRepository.findById(ID).get().getTotalExamWeight());
            return studentRepository.findById(ID).orElse(null);
        }
    }

    public void addStudent(Student student) throws StudentAlreadyExistsException {
        if (!studentExists(student)) {
            studentRepository.save(student);
        } else {
            throw new StudentAlreadyExistsException("Student already exists!");
        }
    }

    public void removeStudent(Student student) throws StudentNotFoundException {
        if (!studentExists(student)) {
            throw new StudentNotFoundException("Student not found");
        } else {
            studentRepository.delete(student);
        }
    }

    public void updateStudent(Student oldStudent, Student newStudent) throws StudentNotFoundException {
        Student student = studentRepository.findById(oldStudent.getStudentID()).get();
        student.setCourseTitle(newStudent.getCourseTitle());
        student.setDateOfBirth(newStudent.getDateOfBirth());
        student.setName(newStudent.getName());
        studentRepository.save(student);
    }

    public boolean studentExists(Student student) {
        return studentRepository.existsById(student.getStudentID());
    }

    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public List<Student> getStudentsByLetter(String s) {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> {
            if (student.getName().startsWith(s)) {
                students.add(student);
            }
        });
        return students;
    }

    public List<Student> getStudentByExamWeight(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        Integer max = Collections.max(students, this::compare).getTotalExamWeight();

        List<Student> maxStudents = new ArrayList<>();
        studentRepository.findAll().forEach(student -> {
            if(student.getTotalExamWeight() == max){
                maxStudents.add(student);
            }
        });
        return maxStudents;
    }

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getTotalExamWeight().compareTo(s2.getTotalExamWeight());
    }
}
