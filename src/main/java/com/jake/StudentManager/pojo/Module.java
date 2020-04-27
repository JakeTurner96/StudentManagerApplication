package com.jake.StudentManager.pojo;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Module{

    @NotNull
    private Integer moduleID;
    private String moduleTitle;
    private String courseworkWeight;
    private String examWeight;

    public Module(){}

    public Module(Integer moduleID, String moduleTitle, String courseworkWeight, String examWeight) {
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

    public String getCourseworkWeight() {
        return courseworkWeight;
    }

    public String getExamWeight() {
        return examWeight;
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
}
