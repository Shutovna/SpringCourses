package com.example.sandbox.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Calendar;

@ControllerAdvice
public class StudentsControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleNotFound(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(ex.getMessage());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setTimestamp(Calendar.getInstance().getTimeInMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAll(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setMessage(ex.getMessage());
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(Calendar.getInstance().getTimeInMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
