package LeetCode;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {

        int max = 0;
        for(int i = 0 ; i<prices.length ; i++){
            int max1 = 0;
            for(int j = i+1 ; j<prices.length ; j++){

                if(prices[j] > prices[i]){
                    max1 = prices[j] - prices[i];
                }
                if(max1 > max){
                    max = max1;
                }
            }

        }
        return max;
    }

    // o(n) solution.
    public static int maxprofit(int[] arr){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < minPrice){
                minPrice = arr[i];
            }
            else if(arr[i] - minPrice > maxProfit){
                maxProfit = arr[i]-minPrice;
            }
        }
       return maxProfit;


    }
    public static void main(String[] args){
        int[] arr = {7,1,5,3,6,4};
        int max = maxProfit(arr);
        System.out.println(max);
        System.out.println(maxprofit(arr));
    }
}
