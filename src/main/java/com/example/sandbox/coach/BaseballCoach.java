package com.example.sandbox.coach;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String trainProgram() {
        return "Run Forest run";
    }
}
