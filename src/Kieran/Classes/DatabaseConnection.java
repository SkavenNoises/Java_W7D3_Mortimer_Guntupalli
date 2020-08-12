package Kieran.Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection connection;

	public DatabaseConnection() throws SQLException {
		Secret secret = new Secret();
		connection = DriverManager.getConnection(secret.getDatabaseURL(), secret.getProperties());
		connection.setAutoCommit(false);
	}

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection() throws SQLException {
		this.connection.close();
	}
}
