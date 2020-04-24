package com.jake.StudentManager;

//import com.jake.StudentManager.services.ModuleService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
//import com.jake.StudentManager.pojo.Module;
import com.jake.StudentManager.pojo.Student;
import com.jake.StudentManager.services.StudentService;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class StudentManagerApplicationTests {

//	static StudentService studentService = new StudentService();
//	static ModuleService moduleService = new ModuleService();
//	static Student student;
//	static Student updatedStudent;
//	static Module module;
//
//	@org.junit.jupiter.api.BeforeAll
//	static void setUp(){
//		 module = new Module(10, "APIs", "80%", "20%");
//		 student = new Student(1, "Computer Science", "Jake Turner", LocalDate.of(1996, 8, 16));
//		 updatedStudent = new Student(1, "Business", "Jake William Turner",  LocalDate.of(1996, 8, 16));
//	}
//
//	@Order(1)
//	@org.junit.jupiter.api.Test
//	public void addStudent(){
//		studentService.addStudent(student);
//		assertTrue(!studentService.getStudentList().isEmpty());
//	}
//
//	@Order(2)
//	@org.junit.jupiter.api.Test
//	public void getStudent(){
//		assertEquals(student, studentService.getStudent(1));
//	}
//
//	@Order(3)
//	@org.junit.jupiter.api.Test
//	public void updateStudent(){
//		studentService.updateStudent(student, updatedStudent);
//		assertEquals(updatedStudent, studentService.getStudent(1));
//	}
}
