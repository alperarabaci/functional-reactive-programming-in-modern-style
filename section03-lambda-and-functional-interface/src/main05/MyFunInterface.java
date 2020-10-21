package main05;

@FunctionalInterface
public interface MyFunInterface {

	public void myMethod();
	
	/**
	 * we can not add additional method if we add @FunctionalInterface annotation
	 */
	//public void myMethod2();
	
}
