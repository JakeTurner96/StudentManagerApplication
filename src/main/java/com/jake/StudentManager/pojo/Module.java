package com.jake.StudentManager.pojo;

public class Module {

    private int moduleID;
    private String moduleTitle;
    private String courseworkWeight;
    private String examWeight;

    public Module(int moduleID, String moduleTitle, String courseworkWeight, String examWeight) {
        this.moduleID = moduleID;
        this.moduleTitle = moduleTitle;
        this.courseworkWeight = courseworkWeight;
        this.examWeight = examWeight;
    }

    public int getModuleID() {
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
}
