package com.problems.EmployeeManagement;

import java.util.Objects;

public class Address {

	int aid;
	int houseno;
	String landmark;
	String location;
	String state;
	String city;
	String country;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, int houseno, String landmark, String location, String state, String city, String country) {
		super();
		this.aid = id;
		this.houseno = houseno;
		this.landmark = landmark;
		this.location = location;
		this.state = state;
		this.city = city;
		this.country = country;
	}

	public int getAid() {
		return aid;
	}

	public void setId(int id) {
		this.aid = id;
	}

	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + aid + ", houseno=" + houseno + ", landmark=" + landmark + ", location=" + location
				+ ", state=" + state + ", city=" + city + ", country=" + country + ", getId()=" + getAid()
				+ ", getHouseno()=" + getHouseno() + ", getLandmark()=" + getLandmark() + ", getLocation()="
				+ getLocation() + ", getState()=" + getState() + ", getCity()=" + getCity() + ", getCountry()="
				+ getCountry() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, houseno, aid, landmark, location, state);
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
				&& aid == other.aid && Objects.equals(landmark, other.landmark)
				&& Objects.equals(location, other.location) && Objects.equals(state, other.state);
	}
	
	
}
