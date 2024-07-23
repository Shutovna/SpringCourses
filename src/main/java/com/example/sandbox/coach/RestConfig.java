package com.example.sandbox.coach;

import com.example.sandbox.coach.Coach;
import com.example.sandbox.coach.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig {
    @Bean("qwertyBean")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

