package main54_iterator;

import java.util.function.Consumer;

public class MyArrayList {

	private Object[] elements = new Object[5];

	public MyArrayList(Object[] elements) {
		this.elements = elements;
	}
	
	public void foreach(Consumer<Object> action) {
		for (Object object : elements) {
			action.accept(object);
		}
	}
	
}
