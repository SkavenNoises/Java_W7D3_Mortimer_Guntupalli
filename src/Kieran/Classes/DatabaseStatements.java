package Kieran.Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseStatements {
	private DatabaseConnection databaseConnection;

	public DatabaseStatements() throws SQLException {
		databaseConnection = new DatabaseConnection();
	}

	public ArrayList<Student> getStudentList() throws SQLException {
		ArrayList<Student> studentArrayList = new ArrayList<>();

		String sql = "SELECT * FROM students";
		Statement statement = this.databaseConnection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int studentId = resultSet.getInt(1);
			String studentName = resultSet.getString(2);
			String studentAddress = resultSet.getString(3);

			studentArrayList.add(new Student(studentId, studentName, studentAddress));
		}

		statement.close();

		return studentArrayList;
	}

	public ArrayList<Course> getCoursesList() throws SQLException {
		ArrayList<Course> courseArrayList = new ArrayList<>();

		String sql = "SELECT * FROM courses";
		Statement statement = this.databaseConnection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next())  {
			int courseID = resultSet.getInt(1);
			String courseName = resultSet.getString(2);

			courseArrayList.add(new Course(courseID, courseName));
		}

		statement.close();

		return courseArrayList;
	}
}
