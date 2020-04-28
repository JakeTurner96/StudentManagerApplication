package com.jake.StudentManager;

import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentManagerApplication {

    private static final Logger log = LoggerFactory.getLogger(StudentManagerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StudentManagerApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository studentRepository) {
        return (args) -> {
            studentRepository.deleteAll();
            List<Module> moduleArrayList = new ArrayList<>();

            Student student1 = new Student("Computer Science", "Jake Turner", LocalDate.of(1996, 8, 16), moduleArrayList);

            Module module1 = new Module(1, "APIs", "20", "80");
            Module module2 = new Module(2, "Data structures", "50", "50");
            Module module3 = new Module(3, "Algorithms", "75", "25");

            student1.getModuleList().add(module1);
            student1.getModuleList().add(module2);
            student1.getModuleList().add(module3);
            studentRepository.save(student1);
        };
    }
}
