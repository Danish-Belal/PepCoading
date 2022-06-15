package LeetCode;

/*
https://leetcode.com/problems/delete-operation-for-two-strings/
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

 */
public class DeleteOperationforTwoStrings {
    public static void main(String[] strs){
        String word1 = "leetcode" , word2 = "etco";
        System.out.println(minDistance(word1 , word2));
    }
    public static int minDistance(String word1, String word2) {
        int length  = lcs( word1 , word2);
        return word1.length() + word2.length() - 2*length ;
    }

    // Solves using dp.
    static int lcs(String str1 , String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];

        for(int i =0 ; i<=str1.length() ; i++){
            for(int j =0 ; j<=str2.length() ; j++){
                if(i == 0 || j == 0) continue;
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
