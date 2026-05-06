package com.problems.EmployeeManagement;

import java.util.Objects;

public class Employee {

	int id;
	String name;
	int age;
	int salary;
	String depname;
	String gender;
	Address address;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, int age, int salary, String depname, String gender, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.depname = depname;
		this.gender = gender;
		this.address = address;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", depname=" + depname
				+ ", gender=" + gender + ", address=" + address + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAge()=" + getAge() + ", getSalary()=" + getSalary() + ", getDepname()=" + getDepname()
				+ ", getGender()=" + getGender() + ", getAddress()=" + getAddress() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, depname, gender, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(depname, other.depname)
				&& Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& salary == other.salary;
	}

	
	
}
