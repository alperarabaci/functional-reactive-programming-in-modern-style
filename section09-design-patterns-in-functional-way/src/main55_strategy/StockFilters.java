package main55_strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilters {
	
	public static List<Stock> bySymbo(List<Stock> list, String symbol) {
		List<Stock> filteredData = new ArrayList<>();
		
		for (Stock stock : list) {
			if(stock.getSymbol().equals(symbol)) {
				filteredData.add(stock);
			}
		}
		
		return filteredData;
	}
	
	public static List<Stock> byPriceAbove(List<Stock> list, double price) {
		List<Stock> filteredData = new ArrayList<>();
		
		for (Stock stock : list) {
			if(stock.getPrice() > price) {
				filteredData.add(stock);
			}
		}
		
		return filteredData;
	}
	
	public static List<Stock> filter(List<Stock> list, Predicate<Stock> predicate) {
		List<Stock> filteredData = new ArrayList<>();
		
		for (Stock stock : list) {
			if(predicate.test(stock)) {
				filteredData.add(stock);
			}
		}
		
		return filteredData;
	}

}
