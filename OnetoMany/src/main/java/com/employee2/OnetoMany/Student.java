package com.employee2.OnetoMany;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String sname;
	@Column(name = "email")
	String emial;
	@Column
	String phone;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	List<Course> ref;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(String sname, String emial, String phone) {
		super();
		this.sname = sname;
		this.emial = emial;
		this.phone = phone;
	}



	public Student(int id, String sname, String emial, String phone, List<Course> ref) {
		super();
		this.id = id;
		this.sname = sname;
		this.emial = emial;
		this.phone = phone;
		this.ref = ref;
	}

	public Student(String sname, String emial, String phone, List<Course> ref) {
		super();
		this.sname = sname;
		this.emial = emial;
		this.phone = phone;
		this.ref = ref;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Course> getRef() {
		return ref;
	}

	public void setRef(List<Course> ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", emial=" + emial + ", phone=" + phone + ", ref=" + ref
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emial, id, phone, ref, sname);
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
		return Objects.equals(emial, other.emial) && id == other.id && Objects.equals(phone, other.phone)
				&& Objects.equals(ref, other.ref) && Objects.equals(sname, other.sname);
	}
	
	
	
}
