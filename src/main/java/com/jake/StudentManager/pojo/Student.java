package com.jake.StudentManager.pojo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student{

    @Id
    private Integer studentID;
    private String courseTitle;
    private String name;
    private LocalDate dateOfBirth;
    @Embedded
    @ElementCollection
    private List<Module> modules;

    protected Student(){}

    public Student( Integer studentID, String courseTitle, String name, LocalDate dateOfBirth) {
        super();
        this.studentID = studentID;
        this.courseTitle = courseTitle;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getStudentID() {
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
        return modules;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", courseTitle='" + courseTitle + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
