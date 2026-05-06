package com.employee2.ManyToMany;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Club {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String club_name;
	
	@ManyToMany(mappedBy = "clubs")
	List<Student> students;

	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Club(String club_name) {
		super();
		this.club_name = club_name;
	}


	public Club(int id, String club_name, List<Student> students) {
		super();
		this.id = id;
		this.club_name = club_name;
		this.students = students;
	}

	public Club(String club_name, List<Student> students) {
		super();
		this.club_name = club_name;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(club_name, id, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		return Objects.equals(club_name, other.club_name) && id == other.id && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "Club [id=" + id + ", club_name=" + club_name + "]";
	}
	
	
}
