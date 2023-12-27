package com.deeponcode.demo.rest;

import com.deeponcode.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents ;

    //Define @PostConstruct to load the student data...only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Provat","Das"));
        theStudents.add(new Student("Rumpa","Das"));
        theStudents.add(new Student("Debangana","Paul"));
    }

    //Define endpoints for "/students" return a list of students

    @GetMapping("students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // Define endpoints or "/student/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //Just index into the list...........keep it simple

        //Check the studentId against list size

        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student Id not Found : "+ studentId);
        }
        return theStudents.get(studentId);
    }

    //Add an exception handler using @ExceptionHandler


    //Add another exception handler .... to catch any type of exception(catch all)

}
