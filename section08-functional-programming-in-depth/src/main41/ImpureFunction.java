package main41;

public class ImpureFunction {

	private int value = 0;

	/**
	 * method changes object state by increasing value.
	 */
	public int add(int nextValue) {
		this.value += nextValue;
		return this.value;
	}

}
