package main04;

public class Main04 {

	public static void main(String[] args) {
		//first alternative is a class which implement Runnable interface
		MyRunnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable);
		t1.start();
		
		//Second alternative is inner class:
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread executed");
			}
		});
		t2.start();
		
		//alternative lambda expression of inner class, just focus on metod body.
		//all unnecessary parts are deleted
		Thread t3 = new Thread(() ->  System.out.println("Thread executed"));
		t3.start();
	}
}
