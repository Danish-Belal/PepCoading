package LeetCode;
/*
https://leetcode.com/problems/count-sorted-vowel-strings/
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.



Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 */
public class CountSortedVowel {
    public static void main(String[] args){
        System.out.println(countVowelStrings(2));
        System.out.println(countSrting(2));
    }

    static char[] ch = new char[]{'a','e','i' , 'o' , 'u'};
    public static int countVowelStrings(int n) {
        int ans = 0 ;
        for(char c : ch){
            ans += count(n-1 , c);
        }
        return ans;
    }
     static int  count(int length , char last_char){
        if(length == 0) return 1;
        int temp  =0 ;
        for(char cnew : ch){
            if(cnew >= last_char){
                temp += count(length-1 , cnew);
            }
        }
        return temp;
    }

    static int countSrting(int n){
        int[][] dp = new int[n+1][6];

        for(int i =1 ; i<=n ; i++){
            for(int j = 1 ; j<=5 ; j++){
                dp[i][j] = (i>1 ? dp[i-1][j]:1)+dp[i][j-1];
            }
        }
        return dp[n][5];
    }
}
