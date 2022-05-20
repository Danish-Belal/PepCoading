package DynamicProgramming;

/*
https://leetcode.com/problems/unique-paths/
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:

1 <= m, n <= 100
 */
public class UniqPath1 {
    public static void main(String[] args){
        System.out.println(uniquePaths(3,7));

    }
    public static int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i = 0 ; i<dp.length ; i++){
            dp[i][0] = 1;
        }
        for(int i = 0 ; i<dp[0].length ; i++){
            dp[0][i] = 1;
        }
        // for(int[] i : dp){
        //     System.out.println(Arrays.toString(i));
        // }

        for(int i =1; i<dp.length ; i++){
            for(int j =1 ; j<dp[0].length ; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        //   for(int[] i : dp){
        //     System.out.println(Arrays.toString(i));
        // }

        return dp[m-1][n-1];

    }
}
