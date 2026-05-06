package com.problems.jdbcProblems;

import java.util.Objects;

public class Student {

	int id;
	String name;
	String gender;
	int age;
	String collage;
	String university;
	int tenth;
	int tweth;
	int deg;
	Address address; // Aggregation

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String gender, int age, String collage, String university, int tenth, int tweth,
			int deg, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.collage = collage;
		this.university = university;
		this.tenth = tenth;
		this.tweth = tweth;
		this.deg = deg;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", collage=" + collage
				+ ", university=" + university + ", tenth=" + tenth + ", tweth=" + tweth + ", deg=" + deg + ", address="
				+ address + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getTenth() {
		return tenth;
	}

	public void setTenth(int tenth) {
		this.tenth = tenth;
	}

	public int getTweth() {
		return tweth;
	}

	public void setTweth(int tweth) {
		this.tweth = tweth;
	}

	public int getDeg() {
		return deg;
	}

	public void setDeg(int deg) {
		this.deg = deg;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, collage, deg, gender, id, name, tenth, tweth, university);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(collage, other.collage)
				&& deg == other.deg && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(name, other.name) && tenth == other.tenth && tweth == other.tweth
				&& Objects.equals(university, other.university);
	}

}
