package algorithms.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuySellStock {
	
/*	While buying and selling a stock once, we determine the maximum profit we get when we buy and 
	sell a stock.
	* {3, 4, 1, 8, 6, 5, 10}. In this example, the maximum profit we can get is by buying the stock
	* during day 3 when the price is 1 and selling it on day 7 when the price is 10.
	* Therefore, our maximum profit is 9.
	*/
	
	public static double maximumProfitByBuyingSellingStockOnceForward(List<Double> stockPrices) {

		double maximumProfit = 0;
		double minimumPrice = Double.MAX_VALUE;
		
		for (double currentPrice : stockPrices) {
			minimumPrice = Math.min(currentPrice, minimumPrice);
			maximumProfit = Math.max(maximumProfit, currentPrice - minimumPrice);
			
		}
		return maximumProfit;
	}
	
	public static double maximumProfitByBuyingSellingStockOnceReverse(List<Double> stockPrices) {

		double maximumProfit = Double.MIN_VALUE;
		double maximumPrice = Double.MIN_VALUE;
		int lastIndex = stockPrices.size() - 1;

		for (int i = lastIndex; i>=0;i--) {
			double currentPrice = stockPrices.get(i);
			maximumPrice = Math.max(currentPrice, maximumPrice);
			maximumProfit = Math.max(maximumProfit, maximumPrice - currentPrice);
		}
		return maximumProfit;
	}
	
	public static double maximumProfitByBuyingAndSellingStockTwice(List<Double> stockPrices) {
		
		int lastIndex = stockPrices.size() - 1;
		List<Double> maximumProfitForFirstBuySell = new ArrayList<>();
		double maximumProfit = 0;
		double minimumPrice = Double.MAX_VALUE;
		
		for (double currentPrice : stockPrices) {
			minimumPrice = Math.min(currentPrice, minimumPrice);
			maximumProfit = Math.max(maximumProfit, currentPrice - minimumPrice);
			maximumProfitForFirstBuySell.add(maximumProfit);
		}
		
		
		double maxPrice = Double.MIN_VALUE;
		System.out.println(maximumProfit);
		for (int i = lastIndex; i>0; i--) {
			double currentPrice = stockPrices.get(i);
			maxPrice = Math.max(maxPrice, currentPrice);
			maximumProfit = Math.max(maximumProfit, maxPrice - currentPrice + maximumProfitForFirstBuySell.get(i-1));
			
		}
		return maximumProfit;

	}
	
	public static void main(String[] args) {
		List<Double> stockPrices1 = new ArrayList<>();
		stockPrices1.add(3D);
		stockPrices1.add(4D);
		stockPrices1.add(1D);
		stockPrices1.add(8D);
		stockPrices1.add(6D);
		stockPrices1.add(5D);
		stockPrices1.add(10D);
		
		List<Double> stockPrices2 = new ArrayList<>();
		stockPrices2.add(3D);
		stockPrices2.add(4D);
		stockPrices2.add(1D);
		stockPrices2.add(8D);
		stockPrices2.add(6D);
		stockPrices2.add(5D);
		stockPrices2.add(10D);
		
	//	Collections.reverse(stockPrices1);
		//Collections.reverse(stockPrices2);
		
		
		
		// double maximumProfitForward = maximumProfitByBuyingSellingStockOnceForward(stockPrices1);
		//double maximumProfitReverse = maximumProfitByBuyingSellingStockOnceReverse(stockPrices2);
		//System.out.println(maximumProfitForward);
		//System.out.println(maximumProfitReverse);
		double maximumProfitTwice = maximumProfitByBuyingAndSellingStockTwice(stockPrices1);
		System.out.println(maximumProfitTwice);
		
	}

}
