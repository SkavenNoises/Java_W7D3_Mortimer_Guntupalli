package Kieran.Classes;

import java.util.Properties;

public class Secret {
	private String username = "root";
	private String password = "ratbox94";
	private String databaseURL = "jdbc:mysql://172.17.0.2:3306/university";
	private Properties properties;

	public Secret() {
		this.properties = new Properties();
		this.properties.put("user", this.username);
		this.properties.put("password", this.password);
	}

	public Properties getProperties() {
		return properties;
	}

	public String getDatabaseURL() {
		return databaseURL;
	}
}
