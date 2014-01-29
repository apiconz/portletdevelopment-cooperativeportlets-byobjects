package pe.com.apiconz.example.bean;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 5377885807756136481L;
	private String name;
	private int age;
	private char gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

}
