
public class Solution {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    int profit = 0;

    for (int i = 1; i < n; i++) {
      int delta = prices[i] - prices[i - 1];
      if (delta > 0) {
        profit += delta;
      }
    }

    return profit;
  }
}
