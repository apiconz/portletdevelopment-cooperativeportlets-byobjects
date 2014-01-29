package pe.com.apiconz.example.event;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import pe.com.apiconz.example.bean.Person;

@XmlRootElement
public class PersonEvent implements Serializable {

	private static final long serialVersionUID = 890260552550032061L;

	private String name;
	private Integer age;
	private Character gender;

	public PersonEvent() {
	}

	public PersonEvent(Person person) {
		this.name = person.getName();
		this.age = person.getAge();
		this.gender = person.getGender();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

}
