package com.infotech.model;

public class Employer {

	private String name;
	private int age;

	public Employer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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

	@Override
	public String toString() {
		return "Employer [name=" + name + ", age=" + age + "]";
	}

}
