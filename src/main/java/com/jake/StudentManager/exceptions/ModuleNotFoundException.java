package com.jake.StudentManager.exceptions;

public class ModuleNotFoundException extends RuntimeException {
    public ModuleNotFoundException(String messgae){
        super(messgae);
    }
}
