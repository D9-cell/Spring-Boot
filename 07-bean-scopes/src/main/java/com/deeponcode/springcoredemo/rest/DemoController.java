package com.deeponcode.springcoredemo.rest;

import com.deeponcode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define a private field for dependency
    private Coach myCoach;
    private Coach anotherCoach;

    //Define a constructor Dependency Injection
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach,
                          @Qualifier("trackCoach") Coach theAnotherCoach){
        System.out.println("In Constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing Beans : myCoach == anotherCoach,  " + (myCoach==anotherCoach);
    }
}
