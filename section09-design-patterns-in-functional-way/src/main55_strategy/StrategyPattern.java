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
		
		StockFilters.bySymbo(stockList, "AMZ").forEach(System.out::println);
		
		System.out.println("------------------------");
		
		StockFilters.byPriceAbove(stockList, 300).forEach(System.out::println);
		
		System.out.println("Lambda:");
		//symbol filter with lambda:
		Predicate<Stock> predicateSymbol = (Stock s) -> s.getSymbol().equals("AMZ");  
		StockFilters.filter(stockList, predicateSymbol).forEach(System.out::println);;
		
		System.out.println("------------------------");
		//price filter with lambda:
		Predicate<Stock> predicatePrice = (Stock s) -> s.getPrice()>300;  
		StockFilters.filter(stockList, predicatePrice).forEach(System.out::println);;
	}
}
