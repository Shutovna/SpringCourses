package com.example.sandbox.coach;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestControlller {
    private final Coach coach;
    private final Coach coach2;

    @Autowired
    public CoachRestControlller(@Qualifier("qwertyBean") Coach coach, Coach coach2) {
        this.coach = coach;
        this.coach2 = coach2;
    }

    @GetMapping
    public String train(@RequestParam(required = false) String name) {
        String s = coach.trainProgram() + " " + (StringUtils.isNullOrEmpty(name) ? "" : name);
        s += coach2.trainProgram() + " " + (StringUtils.isNullOrEmpty(name) ? "" : name);
        return s;
    }
}
