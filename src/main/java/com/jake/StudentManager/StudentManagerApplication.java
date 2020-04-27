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
	public CommandLineRunner demo(StudentRepository studentRepository){
		return (args) -> {
			studentRepository.deleteAll();

			List<Module> moduleArrayList = new ArrayList<>();
			moduleArrayList.add(new Module(1,"title1", "20", "80"));
			moduleArrayList.add(new Module(2,"title2", "50", "50"));

			Student student1 = new Student("Computer Science", "Jake Turner", LocalDate.of(1996, 8, 16), moduleArrayList);
			Student student2 = new Student("Veterinary Medicine", "Hannah Tilbury", LocalDate.of(1995, 9, 11), moduleArrayList);
			Student student3 = new Student("Business", "Adam Robinson", LocalDate.of(1997, 5, 7), moduleArrayList);
			Student student4 = new Student("Economics", "Mia Hardcastle", LocalDate.of(1997, 10, 20), moduleArrayList);
			Student student5 = new Student("Film", "Connor Notman", LocalDate.of(1998, 4, 11), moduleArrayList);

			studentRepository.save(student1);
			studentRepository.save(student2);
			studentRepository.save(student3);
			studentRepository.save(student4);
			studentRepository.save(student5);
		};
	}
}
