package automationExamples.FileReadWritePackage.JSON;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	private String name;
	private int age;
	private boolean isDeveloper;

	private List<String> skills;

	private Address address;
	private String manager;

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

	@JsonProperty("isDeveloper")
	public boolean isDeveloper() {
		return isDeveloper;
	}

	public void setDeveloper(boolean isDeveloper) {
		this.isDeveloper = isDeveloper;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

}
