package com.deeponcode.springboot.cruddemo.dao;

import com.deeponcode.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{


    //Define field for entitymanager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {

        //Create a Query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //Get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //Return Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        //Save Employee
        Employee newEmployee = entityManager.merge(theEmployee);
        //Return the Employee
        return newEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //Find the Employee to be deleted
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //Remove the ID
        entityManager.remove(theEmployee);
    }
}
