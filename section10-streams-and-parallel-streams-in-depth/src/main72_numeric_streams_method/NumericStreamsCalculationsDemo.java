package main72_numeric_streams_method;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamsCalculationsDemo {

	public static void main(String[] args) {
		int sum = IntStream.of(1,2,3,4).sum();
		System.out.println("sum: "+sum);
		
		OptionalInt max = IntStream.of(1,2,3,4).max();
		System.out.println("max:"+max.getAsInt());
		
		//average() OptionalDouble
		
		OptionalDouble avgOptional = IntStream.of(1,2,3,4)
				.average();
		
		System.out.println("avg:" + avgOptional.getAsDouble());
		
		IntSummaryStatistics summaryStatistics = IntStream.of(1,2,3,4)
				.summaryStatistics();
		
		System.out.println("max:" + summaryStatistics.getMax());
		System.out.println("min:" + summaryStatistics.getMin());
		System.out.println("count:" +summaryStatistics.getCount());
		System.out.println("sum:" + summaryStatistics.getSum());
	}
}
