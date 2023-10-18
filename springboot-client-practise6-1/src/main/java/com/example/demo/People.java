package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	private String place;
	private int memberes;
	public People() {
		
	}
	public People(int pid, String place, int memberes) {
		super();
		this.pid = pid;
		this.place = place;
		this.memberes = memberes;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getMemberes() {
		return memberes;
	}
	public void setMemberes(int memberes) {
		this.memberes = memberes;
	}
	@Override
	public String toString() {
		return "People [pid=" + pid + ", place=" + place + ", memberes=" + memberes + "]";
	}
	
	
}
