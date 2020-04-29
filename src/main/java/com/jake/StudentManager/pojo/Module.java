package com.jake.StudentManager.pojo;

import javax.persistence.*;

@Entity
public class Module implements Comparable<Module> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = false)
    private Integer moduleID;
    private String moduleTitle;
    private Integer courseworkWeight;
    private Integer examWeight;

    public Module() {
    }

    public Module(Integer moduleID, String moduleTitle, Integer courseworkWeight, Integer examWeight) {
        super();
        this.moduleID = moduleID;
        this.moduleTitle = moduleTitle;
        this.courseworkWeight = courseworkWeight;
        this.examWeight = examWeight;
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public Integer getCourseworkWeight() {
        return courseworkWeight;
    }

    public Integer getExamWeight() {
        return examWeight;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public void setCourseworkWeight(Integer courseworkWeight) {
        this.courseworkWeight = courseworkWeight;
    }

    public void setExamWeight(Integer examWeight) {
        this.examWeight = examWeight;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleID=" + moduleID +
                ", moduleTitle='" + moduleTitle + '\'' +
                ", courseworkWeight='" + courseworkWeight + '\'' +
                ", examWeight='" + examWeight + '\'' +
                '}';
    }

    @Override
    public int compareTo(Module module) {
        return module.getModuleID();
    }
}
