package main76_paralel_stream.warmup;

public class ManualClassLoader {
	
	public static void warmUp() {
		for (int i = 0; i < 100000; i++) {
			Dummy dummy = new Dummy();
			dummy.m();
		}
	}

	static class Dummy {
		public void m() {}
	}
	
}