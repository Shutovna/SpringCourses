package com.example.sandbox.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentErrorResponse {
    private int statusCode;
    private String message;
    private long timestamp;
}
