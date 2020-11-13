package com.training.l136_operators_in_action;

class Employee {

	private int id;
	private String name;
	private double salary;
	private double rating;
	
	public Employee(int id, String name, double salary, double rating) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.rating = rating;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
