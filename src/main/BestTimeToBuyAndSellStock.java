package main;

/**
 * Created by ysun on 5/18/16.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            min = min < i ? min : i;
            profit = i - min > profit ? i - min : profit;
        }
        return profit;
    }
}
