package com.deeponcode.springboot.thymeleafdemo.controller;

import com.deeponcode.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        //Create A Student Object
        Student theStudent = new Student();

        //Add Student object to the model
        theModel.addAttribute("student",theStudent);

        //Add the List of the Countries to the Model
        theModel.addAttribute("countries",countries);

        //Add the List of the languages to the Model
        theModel.addAttribute("languages",languages);

        //Add the List of the operatingsystems to the Model
        theModel.addAttribute("systems",systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processsForm(@ModelAttribute("student") Student theStudent){

        //Log the input Data
        System.out.println("The Student : " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
