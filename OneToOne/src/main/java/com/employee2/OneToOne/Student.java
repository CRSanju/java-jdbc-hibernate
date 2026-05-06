package com.employee2.OneToOne;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int sid;
	@Column
	String sname;
	@Column
	int marks;
	@Column
	int sage;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid", referencedColumnName = "addrid")
	Address addr;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, int marks, int sage, Address addr) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.marks = marks;
		this.sage = sage;
		this.addr = addr;
	}

	public Student(String sname, int marks, int sage, Address addr) {
		super();
		this.sname = sname;
		this.marks = marks;
		this.sage = sage;
		this.addr = addr;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", marks=" + marks + ", sage=" + sage + ", addr=" + addr
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addr, marks, sage, sid, sname);
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
		return Objects.equals(addr, other.addr) && marks == other.marks && sage == other.sage && sid == other.sid
				&& Objects.equals(sname, other.sname);
	}
	
	
	
}
