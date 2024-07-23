package com.example.sandbox.student;

import lombok.Data;

@Data
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
