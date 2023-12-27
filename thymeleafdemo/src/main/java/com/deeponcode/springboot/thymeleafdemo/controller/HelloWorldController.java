package com.deeponcode.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //need a controller method to show a initial HTML form

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to show a process HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String processForm(HttpServletRequest request, Model model){

        //Read the request parameter from the HTML Form
        String studentName = request.getParameter("studentName");

        //Work on the parameter
        studentName = studentName.toUpperCase();
        String result = "Hello " + studentName;

        //adding the updated value to the model
        model.addAttribute("result",result);

        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model){

        //Work on the parameter
        studentName = studentName.toUpperCase();
        String result = "Hey My friend " + studentName;

        //adding the updated value to the model
        model.addAttribute("result",result);

        return "helloworld";
    }
}
