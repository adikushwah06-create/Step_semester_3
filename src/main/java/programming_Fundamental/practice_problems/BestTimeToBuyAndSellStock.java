package main.java.programming_Fundamental.practice_problems;

public class BestTimeToBuyAndSellStock {

    /**
     * Finds the maximum profit possible from a single buy and sell transaction.
     * Traverses the prices array in a single pass (left to right).
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Check potential profit if sold on day i
            int currentProfit = prices[i] - minPrice;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            // Update the minimum buying price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1)); // Output: 5

        // Sample Test Case 2 (Strictly decreasing prices)
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2)); // Output: 0
    }
}