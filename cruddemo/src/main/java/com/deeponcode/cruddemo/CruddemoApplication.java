package com.deeponcode.cruddemo;

import com.deeponcode.cruddemo.dao.StudentDAO;
import com.deeponcode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createMultipleStudent(studentDAO);

			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting All Students....");
		int numOfStudentDeleted = studentDAO.deleteAll();
		System.out.println("Number Of Students Deleted : " + numOfStudentDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentID = 4;
		System.out.println("Deleting the student eith ID : " + studentID);
		studentDAO.delete(studentID);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id : primary key
		int studentId = 4;
		System.out.println("Getting Student with ID : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first letter name to Scooby
		System.out.println("Updating Student..");
		myStudent.setFirstName("Deepon");
		myStudent.setLastName("Das");
		myStudent.setEmail("deeponsubhro@gmail.com");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student : " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//Get a list of Student
		List<Student> theStudents = studentDAO.findByLAstName("Das");

		//Display the List of Student
		for (Student tempStudent:
			 theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		//Get a list of student
		List<Student> theStudents = studentDAO.findAllOrderByLastName();

		//Display list of Student
		for (Student tempStudent:
			 theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		//Create a student object
		System.out.println("Creating the Student.....");
		Student student = new Student("Sunasir","Ghosh","sunasirghosh@gmail.com");

		//Save the Student
		System.out.println("Saving the Student...");
		studentDAO.save(student);

		//Display ID of the saved Student
		int theID = student.getId();
		System.out.println("Saved Student.Generated ID : " + theID);

		//retrieve student based on the id : primary key
		System.out.println("Retrieving The Student by ID :" + theID);
		Student retrievedStudent = studentDAO.findById(theID);

		//display student
		System.out.println("Found the Student : " + retrievedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//Create Multiple Students
		System.out.println("Creating the student objects....");
		Student student1 = new Student("Provat","Das","provatdas@gmail.com");
		Student student2 = new Student("Rumpa","Das","rumpadas@gmail.com");
		Student student3 = new Student("Debangana","paul","debanganapaul@gmail.com");

		//save the student objects
		System.out.println("Saving Students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//Create the student object
		System.out.println("Creating the student object ....");
		Student student = new Student("Deepon","Das","deeponsubhro@gmail.com");

		//Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		//display id of the save student
		System.out.println("Saved student.Generate ID : " + student.getId());
	}
}
