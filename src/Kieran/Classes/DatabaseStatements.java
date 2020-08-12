package Kieran.Classes;

import java.sql.*;
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

	public void displayStudentList() throws SQLException {
		String studentHeader = String.format("%3s %20s %20s", "ID", "Name", "Address");
		System.out.println("Students:");
		System.out.println("-".repeat(studentHeader.length()));
		System.out.println(studentHeader);
		System.out.println("-".repeat(studentHeader.length()));

		for (Student student : this.getStudentList()) {
			System.out.println(String.format("%3s %20s %20s", student.getId(), student.getName(), student.getAddress()));
		}

		System.out.println("\n");
	}

	public void displayCoursesList() throws SQLException {
		String coursesHeader = String.format("%3s %20s", "ID", "Name");
		System.out.println("Courses:");
		System.out.println("-".repeat(coursesHeader.length()));
		System.out.println(coursesHeader);
		System.out.println("-".repeat(coursesHeader.length()));

		for (Course course : this.getCoursesList()) {
			System.out.println(String.format("%3s %20s", course.getId(), course.getName()));
		}

		System.out.println("\n");
	}

	public void insertStudent(Student student) throws SQLException {
		System.out.println(String.format("Inserting %s into Student's Database", student.getName()));

		String sql = "INSERT INTO students(name, address) VALUES (?, ?)";
		PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, student.getName());
		preparedStatement.setString(2, student.getAddress());

		preparedStatement.executeUpdate();

		preparedStatement.close();

		System.out.println("Done!");
	}

	public void updateStudentName(int studentID, String studentName) throws SQLException {
		System.out.println("Updating student's name...");

		String sql = "UPDATE students SET name=? WHERE id=? ";
		PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, studentName);
		preparedStatement.setInt(2, studentID);

		preparedStatement.executeUpdate();
		preparedStatement.close();

		System.out.println("Done!");
	}

	public void updateStudentAddress(int studentID, String studentAddress) throws SQLException {
		System.out.println("Updating student's address");

		String sql = "UPDATE students SET address=? WHERE ID=?";
		PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, studentAddress);
		preparedStatement.setInt(2, studentID);

		preparedStatement.executeUpdate();
		preparedStatement.close();

		System.out.println("Done!");
	}

	public void deleteStudent(int studentID) throws SQLException {
		System.out.println("Removing student...");

		String sql = "DELETE FROM students WHERE id=?";
		PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, studentID);

		preparedStatement.executeUpdate();
		preparedStatement.close();

		System.out.println("Done!");
	}

	public void insertCourse(Course course) throws SQLException {
		System.out.println(String.format("Inserting %s into Courses' Database", course.getName()));

		String sql = "INSERT INTO courses(name) VALUES (?)";
		PreparedStatement preparedStatement = this.databaseConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1, course.getName());

		preparedStatement.executeUpdate();

		preparedStatement.close();

		System.out.println("Done!");
	}

	public DatabaseConnection getDatabaseConnection() {
		return databaseConnection;
	}
}
