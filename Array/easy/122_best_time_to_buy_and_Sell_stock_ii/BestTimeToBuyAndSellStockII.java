//
// Created by Joshua.Cao, 2018/10/025
//
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
//

public class BestTimeToBuyAndSellStockII {
  // Accepted, beats 99.61%
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }

  // Accepted, beats 17.61%
  public int maxProfit_2(int[] prices) {
    if (prices.length <= 1) return 0;
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[i - 1]) continue;
      profit += prices[i] - prices[i - 1];
    }
    return profit;
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStockII obj = new BestTimeToBuyAndSellStockII();
    int[] input = {7,1,5,3,6,4};
    System.out.println(obj.maxProfit(input));
  }
}