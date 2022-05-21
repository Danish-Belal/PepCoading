package DynamicProgramming;

/*
https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
 */
public class CoinChangeLeet {
    public static void main(String[] args){
        System.out.println(coinChange(new int[]{1,2,5} , 11));
    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n+1][amount+1];

        for(int i = 0 ; i<=n ; i++){
            for(int j = 0 ; j<=amount ; j++){
                if(j == 0){
                    dp[i][j] = 0;
                }else if(i ==0 ){
                    dp[i][j] =(int) 1e5;
                }else if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j]);
                }
            }
        }
        return dp[n][amount] > 1e4 ? -1 : dp[n][amount];
    }
}
