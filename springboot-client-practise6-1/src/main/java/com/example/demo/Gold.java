package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Gold {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String price;
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<People>people=new HashSet<>();
	public Gold() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Set<People> getPeople() {
		return people;
	}
	public void setPeople(Set<People> people) {
		this.people = people;
	}
	public Gold(int id, String price, Set<People> people) {
		super();
		this.id = id;
		this.price = price;
		this.people = people;
	}
	@Override
	public String toString() {
		return "Gold [id=" + id + ", price=" + price + ", people=" + people + "]";
	}
	
	

}
