package com.deeponcode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practise your backhand volley for 45 minutes.";
    }
}
