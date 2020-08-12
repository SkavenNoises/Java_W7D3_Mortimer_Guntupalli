package Kieran.Classes;

public class Student {
	private int id;
	private String name;
	private String address;

	public Student(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Student(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getId() {
		return id;
	}
}
