package main113_callback_hell;

/**
 * When you are having multiple callbacks it becomes very difficult to manage
 * the callbacks as this is like a go-to statement and difficult to trace where
 * the program pointer is during the execution and this is called a callback
 * hell rx java solves this problem by working on observer design pattern and as
 * we'll move further in this course we'll see how observer pattern makes
 * callback functions very easy.
 * 
 * @author alper
 *
 */
public class CallBackDemo113 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread is running.");

		Runnable r = new Runnable() {
			@Override
			public void run() {
				new CallBackDemo113().runningAsyn(new CallBack() {

					@Override
					public void call() {
						System.out.println("Callback called.");
					}
				});
			}
		};
		Thread t = new Thread(r);
		t.start();

		Thread.sleep(2000);

		System.out.println("Main thread completed.");
	}

	public void runningAsyn(CallBack callback) {
		System.out.println("I am running separate thread");
		sleep(1000);
		callback.call();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
}
