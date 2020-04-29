package com.jake.StudentManager.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Student implements Comparable<Student>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentID;
    private String courseTitle;
    private String name;
    private LocalDate dateOfBirth;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_modules", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "module_id")})
    private Set<Module> moduleSet = new TreeSet<>();

    public Student() {
    }

    public Student(String courseTitle, String name, LocalDate dateOfBirth, Set<Module> moduleSet) {
        super();
        this.courseTitle = courseTitle;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.moduleSet = moduleSet;
    }

    public Integer getTotalExamWeight(){
        return moduleSet.stream().mapToInt(Module::getExamWeight).sum();
    }

    public int getStudentID() {
        return this.studentID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Set<Module> getModuleSet() {
        return moduleSet;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", courseTitle='" + courseTitle + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", moduleSet=" + moduleSet +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return student.getStudentID();
    }
}
