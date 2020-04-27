package com.jake.StudentManager.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;
    private String courseTitle;
    private String name;
    private LocalDate dateOfBirth;
    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "studentID"))
    private List<Module> moduleList = new ArrayList<>();

    public Student(){}

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

    public List<Module> getModuleList(){
        return moduleList;
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
