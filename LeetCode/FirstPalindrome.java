package LeetCode;
/*
https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
Given an array of strings words, return the first palindromic string in the array.
 If there is no such string, return an empty string "".

A string is palindromic if it reads the same forward and backward.



Example 1:

Input: words = ["abc","car","ada","racecar","cool"]
Output: "ada"
Explanation: The first string that is palindromic is "ada".
Note that "racecar" is also palindromic, but it is not the first.
 */
public class FirstPalindrome {
    private static boolean isPoli(String s){
        int i = 0; int j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public String firstPalindrome(String[] words) {
        for(int i = 0 ;i <words.length ; i++){
            String ss = words[i];
            if(isPoli(ss) == true) return ss;
        }
        return "";
    }
}
