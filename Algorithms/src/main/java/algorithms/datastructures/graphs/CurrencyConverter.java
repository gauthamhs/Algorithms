package algorithms.datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Currency{
	
	String fromCurrency;
	String toCurrency;
	double rate;
	
	public Currency(String fromCurrency, String toCurrency, double rate) {
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rate = rate;
	}
}

public class CurrencyConverter {

	public static double currencyConverter(List<Currency> currencies, String fromCurrency, String toCurrency) {
		
		Set<String> currencyNotes = new LinkedHashSet<>();
		
		for(Currency currency : currencies) {
			currencyNotes.add(currency.fromCurrency);
			currencyNotes.add(currency.toCurrency);
		}
		
		Map<String, Integer> currencyMap = new TreeMap<>();
		int idx = 0;
		
		for(String currencyNote : currencyNotes) {
			currencyMap.putIfAbsent(currencyNote, idx++);
		}
		
		double[][] dp = new double[currencyNotes.size()][currencyNotes.size()];
		
		for(double[] d : dp) {
			Arrays.fill(d, -1.0);
		}
		
		for(int i=0;i<currencyNotes.size();i++) {
			dp[i][i] = 1;
		}
		
		for(Currency currency : currencies) {
			Integer fromCurrencyValue = currencyMap.get(currency.fromCurrency);
			Integer toCurrencyValue = currencyMap.get(currency.toCurrency);
			
			dp[fromCurrencyValue][toCurrencyValue] = currency.rate;
			dp[toCurrencyValue][fromCurrencyValue] = 1/(currency.rate);
		}
		for(int i=currencyNotes.size()-1;i>=0;i--) {
			for(int j= i+1;j<dp[0].length;j++) {
				dp[i][j] = dp[i][j-1]*dp[i+1][j]/(dp[i+1][j-1]);
				dp[j][i] = 1/dp[i][j];
			}
		}
		
		return dp[currencyMap.get(fromCurrency)][currencyMap.get(toCurrency)];
		
	}
	
	public static void main(String[] args) {
		
		Currency currency1 = new Currency("USD", "INR", 75.00);
		Currency currency2 = new Currency("INR", "PAK", 30.00);
		Currency currency3 = new Currency("PAK", "ZMB", 4.00);
		
		List<Currency> currencies = new ArrayList<>();
		currencies.add(currency1);
		currencies.add(currency2);
		currencies.add(currency3);
		
		double rate = currencyConverter(currencies, "USD", "ZMB");
		System.out.println(rate);
		
		
		
	}

}
