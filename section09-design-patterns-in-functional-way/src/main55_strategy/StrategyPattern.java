package main55_strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {

	public static void main(String[] args) {
		List<Stock> stockList = new ArrayList<>();
		stockList.add(new Stock("AAPL", 318.65, 10));
		stockList.add(new Stock("MSFT", 166.86, 45));
		stockList.add(new Stock("Google", 99, 12.5));
		stockList.add(new Stock("AMZ", 1866.74, 45));
		stockList.add(new Stock("GOOGL", 1480.20, 3.5));
		stockList.add(new Stock("AAPL", 318.65, 8));
		stockList.add(new Stock("AMZ", 1866.74, 9));
		
		alternativeWay("Classic:");
		
		StockFilters.bySymbo(stockList, "AMZ").forEach(System.out::println);
		
		split();
		
		StockFilters.byPriceAbove(stockList, 300).forEach(System.out::println);
		
		alternativeWay("Lambda:");
		//symbol filter with lambda:
		//Predicate<Stock> predicateSymbol = (Stock s) -> s.getSymbol().equals("AMZ");  
		//JVM can understand type of s using definition of Predicate<Stock>. 
		//So we can use "s" instead of "Stock s" 
		Predicate<Stock> predicateSymbol = s -> s.getSymbol().equals("AMZ");
		StockFilters.filter(stockList, predicateSymbol).forEach(System.out::println);
		
		split();
		//price filter with lambda:
		Predicate<Stock> predicatePrice = (Stock s) -> s.getPrice()>300;  
		StockFilters.filter(stockList, predicatePrice).forEach(System.out::println);
		
		//stream alternative:		
		alternativeWay("Stream:");
		
		stockList.stream()
			.filter(s -> s.getSymbol().equals("AMZ"))
			.forEach(System.out::println);
		
		split();
		
		stockList.stream()
		.filter(s -> s.getPrice()>300)
		.forEach(System.out::println);
	}

	private static void alternativeWay(String title) {
		System.out.println(title);
	}

	private static void split() {
		System.out.println("------------------------");
	}
}
