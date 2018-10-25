//
// Created by Joshua.Cao, 2018/10/25
//
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
//

public class BestTimeToBuyAndSellStock {
  // Accepted, beats 99.92%
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;

    int maximum = 0, profit = 0;
    for (int i = 1; i < prices.length; i++) {
      profit += prices[i] - prices[i - 1];
      if (profit > maximum) {
        maximum = profit;
      }
      if (profit < 0) profit = 0;
    }
    return maximum;
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
    int[] input = {7,1,5,3,6,4};
    System.out.println(obj.maxProfit(input));
  }
}