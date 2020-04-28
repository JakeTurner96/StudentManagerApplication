package com.jake.StudentManager.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private int studentID;
    private String courseTitle;
    private String name;
    private LocalDate dateOfBirth;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private List<Module> moduleList = new ArrayList<>();

    public Student() {
    }

    public Student(String courseTitle, String name, LocalDate dateOfBirth, List<Module> moduleList) {
        super();
        this.courseTitle = courseTitle;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.moduleList = moduleList;
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

    public List<Module> getModuleList() {
        return moduleList;
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
                ", moduleList=" + moduleList +
                '}';
    }
}
