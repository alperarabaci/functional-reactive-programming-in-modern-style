package main59_builder;

public class BuilderDemo {

	public static void main(String[] args) {
		MobileBuilder builder = new MobileBuilder();
		
		/**
		 * I prefer classic builder instead of this.
		 * Check:
		 * https://github.com/alperarabaci/design-patterns/blob/master/s04-builder/src/main/java/com/training/builderv2/ClientV2.java
		 * 
		 */
		Mobile myMobile = builder.with( myBuilder -> {
			myBuilder.ram = 4;
			myBuilder.battery = 4000;
			myBuilder.processor = "A12 Bionic";
		}).createMobile();
		
		System.out.println(myMobile);
		
	}
}
