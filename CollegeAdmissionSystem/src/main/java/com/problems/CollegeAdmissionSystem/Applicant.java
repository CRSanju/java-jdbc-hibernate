package com.problems.CollegeAdmissionSystem;

import java.util.Objects;

public class Applicant {

	int id;
	String name;
	String course;
	int marks;

	public Applicant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Applicant(int id, String name, String course, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.marks = marks;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", course=" + course + ", marks=" + marks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, id, marks, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		return Objects.equals(course, other.course) && id == other.id && marks == other.marks
				&& Objects.equals(name, other.name);
	}

}
