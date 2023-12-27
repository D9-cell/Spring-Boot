package com.deeponcode.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }

    // Define our init Method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStaff : " + getClass().getSimpleName());
    }
    // Define our destroy Method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5km !!!";
    }
}
