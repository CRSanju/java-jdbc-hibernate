package com.employee2.ManyToMany;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_club", 
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "club_id")
			)
	List<Club> clubs;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public Student(int id, String name, String email, List<Club> clubs) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.clubs = clubs;
	}

	public Student(String name, String email, List<Club> clubs) {
		super();
		this.name = name;
		this.email = email;
		this.clubs = clubs;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clubs, email, id, name);
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
		return Objects.equals(clubs, other.clubs) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", clubs=" + clubs + "]";
	}
	
	
}
