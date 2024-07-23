package com.example.sandbox.student;

import jakarta.annotation.PostConstruct;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsRestController {

    private static List<Student> students;

    @PostConstruct
    public void setData() {
        students = List.of(new Student("Nikita", "Shutov", "Shutov@gmail.com"),
                new Student("Nikita2", "Shutov2", "Shutov2@gmail.com"),
                new Student("Nikita3", "Shutov3", "Shutov3@gmail.com"),
                new Student("Nikita4", "Shutov4", "Shutov@4gmail.com"));
    }

    @GetMapping("/students")
    List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        if (id < 0 || id >= students.size()) {
            throw new StudentNotFoundException("Student " + id + " not found");
        }
        return students.get(id);
    }

}
