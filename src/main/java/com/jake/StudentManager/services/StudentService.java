package com.jake.StudentManager.services;

import com.jake.StudentManager.exceptions.StudentAlreadyExistsException;
import com.jake.StudentManager.exceptions.StudentNotFoundException;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class StudentService implements Comparator<Student> {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EntityManager entityManager;

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

    public Set<Student> getStudentSet() {
        Set<Student> students = new TreeSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Set<Student> getStudentsByLetter(String s) {
        return studentRepository.findAllStudentsByLetter(s);
    }

    public List<Student> getStudentByExamWeight() {
        List<Student> list = new ArrayList<>();
        studentRepository.findAll().forEach(list::add);

        int max = list.stream().max(this::compare).get().getTotalExamWeight();

        List<Student> maxList = new ArrayList<>();
        list.forEach(student -> {
            if(student.getTotalExamWeight() == max){
                maxList.add(student);
            }
        });

        return maxList;
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

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getTotalExamWeight().compareTo(s2.getTotalExamWeight());
    }
}
