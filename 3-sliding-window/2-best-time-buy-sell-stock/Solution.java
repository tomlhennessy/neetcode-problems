

public class Solution {
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    int profit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else {
        profit = prices[i] - minPrice;

        maxProfit = Math.max(profit, maxProfit);
      }
    }

    return maxProfit;
  }
}
