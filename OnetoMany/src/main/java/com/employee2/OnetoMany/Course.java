package com.employee2.OnetoMany;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	@Column
	String cname;
	
	@ManyToOne
	@JoinColumn(name = "sid")
	Student student;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Course(String cname) {
		super();
		this.cname = cname;
	}


	public Course(int cid, String cname, Student student) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.student = student;
	}
	public Course(String cname, Student student) {
		super();
		this.cname = cname;
		this.student = student;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", student=" + student + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cid, cname, student);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return cid == other.cid && Objects.equals(cname, other.cname) && Objects.equals(student, other.student);
	}
	

}
