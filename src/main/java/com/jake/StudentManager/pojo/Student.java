package com.jake.StudentManager.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student{

    private Integer studentID;
    private String courseTitle;
    private String name;
    private LocalDate dateOfBirth;
    private List<Module> modules;

    public Student(int studentID, String courseTitle, String name, LocalDate dateOfBirth) {
        super();
        this.studentID = studentID;
        this.courseTitle = courseTitle;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        modules = new ArrayList<>();
    }

    public Integer getStudentID() {
        return this.studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setModule(Module module) {
        this.modules.add(module);
    }

    public void removeModule(Module module) {
        modules.remove(module);
    }

    public List<Module> getModuleList(){
        return modules;
    }


}
