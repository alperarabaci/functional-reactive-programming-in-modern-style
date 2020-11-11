package main54_iterator;

public class IteratorPatternDemo {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(new Object[] {1, 3, 4, 67, 8});
		list.foreach(System.out::println);
	}
	
}
