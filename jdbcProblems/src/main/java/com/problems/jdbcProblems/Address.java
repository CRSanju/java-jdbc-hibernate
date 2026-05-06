package com.problems.jdbcProblems;

import java.util.Objects;

public class Address {

	int id;
	int houseno;
	String steetname;
	String city;
	String state;
	String country;
	int pincode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, int houseno, String steetname, String city, String state, String country, int pincode) {
		super();
		this.id = id;
		this.houseno = houseno;
		this.steetname = steetname;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", houseno=" + houseno + ", steetname=" + steetname + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pincode=" + pincode + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}

	public String getSteetname() {
		return steetname;
	}

	public void setSteetname(String steetname) {
		this.steetname = steetname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, houseno, id, pincode, state, steetname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country) && houseno == other.houseno
				&& id == other.id && pincode == other.pincode && Objects.equals(state, other.state)
				&& Objects.equals(steetname, other.steetname);
	}

}
