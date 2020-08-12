package Kieran;

import Kieran.Classes.DatabaseStatements;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		try {
			DatabaseStatements databaseStatements = new DatabaseStatements();

			// Displaying the student list as a table
			databaseStatements.displayStudentList();

			// Displaying the courses as a table
			databaseStatements.displayCoursesList();

			// Inserting singular student into the DB
			//databaseStatements.insertStudent(new Student("test", "test"));

			// Inserting singular course into the DB
			//databaseStatements.insertCourse(new Course("History"));

			// Updating Student's name
			//databaseStatements.updateStudentName(14, "Sam");

			// Updating Student's address
			//databaseStatements.updateStudentAddress(14, "Hollywood Bv.");

			// Deleting a student from the DB
			//databaseStatements.deleteStudent(14);

			// Committing updates
			databaseStatements.getDatabaseConnection().getConnection().commit();

			// Closing the database connection
			databaseStatements.getDatabaseConnection().getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
