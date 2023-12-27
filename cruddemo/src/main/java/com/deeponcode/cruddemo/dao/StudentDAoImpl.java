package com.deeponcode.cruddemo.dao;

import com.deeponcode.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAoImpl implements StudentDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //define entity manager using constructor injection
    @Autowired
    public StudentDAoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public List<Student> findAll() {
        //Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

        //Return Query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findAllOrderByLastName() {
        //Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        //Return Query Result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numOfStudentDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numOfStudentDeleted;
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //retreive the student
        Student theStudent = entityManager.find(Student.class,id);

        //Delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    public List<Student> findByLAstName(String theLasrName) {

        //Create a Query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student where lastName=:theData", Student.class);

        //Set query parameters
        theQuery.setParameter("theData",theLasrName);

        //Return Query Result
        return theQuery.getResultList();
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }
}
