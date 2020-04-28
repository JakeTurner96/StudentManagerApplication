package com.jake.StudentManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagerApplication {

    private static final Logger log = LoggerFactory.getLogger(StudentManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerApplication.class, args);
    }
}
