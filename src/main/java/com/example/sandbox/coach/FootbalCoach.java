package com.example.sandbox.coach;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootbalCoach implements Coach{
    @Override
    public String trainProgram() {
        return "More goals!!!";
    }
}
