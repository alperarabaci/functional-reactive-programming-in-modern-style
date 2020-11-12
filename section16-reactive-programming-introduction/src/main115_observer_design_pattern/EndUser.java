package main115_observer_design_pattern;

public class EndUser implements Observer {

	private String name;
	
	public EndUser(String name, SubjectLibrary subject) {
		this.name = name;
		subject.subscribeObserver(this);
	}
	
	@Override
	public void update(String avail) {
		System.out.println("Hello " + name+ "! We are glad to notify you your book is now" + avail);
	}

}
