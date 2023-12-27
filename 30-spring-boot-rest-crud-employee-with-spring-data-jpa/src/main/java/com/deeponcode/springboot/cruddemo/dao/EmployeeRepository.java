package com.deeponcode.springboot.cruddemo.dao;

import com.deeponcode.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    //That's it .... No Need to code here
}
