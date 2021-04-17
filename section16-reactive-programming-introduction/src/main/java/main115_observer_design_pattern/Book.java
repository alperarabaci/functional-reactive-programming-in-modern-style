package main115_observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

class Book implements SubjectLibrary{

	private String name;
	private String type;
	private String author;
	private double price;
	private String inStock;
	private List<Observer> observers = new ArrayList<>();
	
	public Book(String name, String type, String author, double price, String inStock) {
		this.name = name;
		this.type = type;
		this.author = author;
		this.price = price;
		this.inStock = inStock;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
		System.out.println("Availability changed from Sold out to Back in stock \n");
		notifyObserver();
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	@Override
	public void subscribeObserver(Observer ob) {
		observers.add(ob);
	}

	@Override
	public void unSubscribeObserver(Observer ob) {
		observers.remove(ob);
	}

	@Override
	public void notifyObserver() {
		System.out.println(toString() + " So, please notify all users");
		
		for (Observer observer : observers) {
			observer.update(this.inStock);
		}
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", type=" + type + ", author=" + author + ", price=" + price + ", inStock="
				+ inStock + "]";
	}
	
	
	
}
