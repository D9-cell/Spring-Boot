package com.deeponcode.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //Expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello Deepon!";
    }

    //Expose a new endpoint for "Workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a Hard 5KM!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is Your lucky day";
    }

}
