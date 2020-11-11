package main77_stateless_stateful_operations;

import java.util.List;
import java.util.stream.Collectors;

public class StatelessStatefulOp {

	public static void main(String[] args) {

		List<Integer> list = List.of(1, 2, 4, 5, 6, 7, 9);
		// skip javadoc:
		/*
		 * This is a stateful intermediate operation.
		 */
		
	
		//limit javadoc:
		/*
		 * This is a short-circuiting stateful intermediate operation.
		 * 
		 */
		List<Integer> collect = list.parallelStream().skip(2).limit(5).collect(Collectors.toList());
		
	}

}
