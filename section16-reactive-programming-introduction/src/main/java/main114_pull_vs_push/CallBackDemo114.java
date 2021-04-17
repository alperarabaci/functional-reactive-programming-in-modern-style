package main114_pull_vs_push;

/**
 * 
 * The main thread completes so this is push once the callback is created in a
 * separate thread the data and other signals are pushed through and rx java
 * makes it very simple as it is built on top of observer design pattern
 * 
 * @author alper
 *
 */
public class CallBackDemo114 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread is running.");

		Runnable r = new Runnable() {
			@Override
			public void run() {
				new CallBackDemo114().runningAsyn(new CallBack() {

					@Override
					public void pushData(String data) {
						System.out.println("Callback data:" + data);

					}

					@Override
					public void pushComplete() {
						System.out.println("Callback done!");
					}

					@Override
					public void pushError(Exception ex) {
						System.out.println("Callback error:" + ex);
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
		callback.pushData("Data 1");
		callback.pushData("Data 2");
		callback.pushData("Data 3");
		callback.pushData("Data 4");

		callback.pushError(new RuntimeException("Error"));
		callback.pushComplete();
	}

	private void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}
}
