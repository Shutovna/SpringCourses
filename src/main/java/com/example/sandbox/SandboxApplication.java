package com.example.sandbox;

import com.example.sandbox.student.Student;
import com.example.sandbox.student.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class SandboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SandboxApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
            IntStream.range(0, (int) Math.ceil(Math.random() * 10)).forEach(i -> {
                Student student = new Student(
                        "Student" + i,
                        "Surname" + i,
                        String.format("qwe%d@qweq.ru", i));
                System.out.println("student before save = " + student);
                studentDAO.save(student);

                Student savedStudent = studentDAO.findById(student.getId());
                System.out.println("student after save = " + savedStudent);

                if (i % 2 == 0) {
                    savedStudent.setEmail("NewEmail@gmail.com");
                    studentDAO.update(savedStudent);
                }
            });


            List<Student> students = studentDAO.findAll();
            System.out.println("all students = " + students);

            for (int i = 0; i < students.size(); i++) {
                if (i % 2 == 0) {
                    studentDAO.delete(students.get(i));
                }
            }

            List<Student> byLastname = studentDAO.findByLastname("Surname");
            System.out.println("byLastname = " + byLastname);

            int num = studentDAO.deleteAll();
            System.out.println("num deleted = " + num);
        };
    }
}
