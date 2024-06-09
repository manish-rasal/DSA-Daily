/**
 * Problem: Best Time to Buy and Sell Stock II
 * Description: You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
class Solution {
    private Integer[][] memo;

    private int solve(int[] prices, int i, int canBuy) {
        if (i >= prices.length) return 0;

        if (memo[i][canBuy] != null) return memo[i][canBuy];

        if (canBuy == 1) {
            int buy = -prices[i] + solve(prices, i + 1, 0);
            int skip = solve(prices, i + 1, 1);
            memo[i][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(prices, i + 1, 1);
            int skip = solve(prices, i + 1, 0);
            memo[i][canBuy] = Math.max(sell, skip);
        }

        return memo[i][canBuy];
    }

    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        return solve(prices, 0, 1);
    }
}