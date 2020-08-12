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

			// Closing the database connection
			databaseStatements.closeConnection();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
