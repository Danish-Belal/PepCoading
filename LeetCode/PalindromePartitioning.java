package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/palindrome-partitioning/
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path , res);
        return res;
    }
    static void func(int idx , String s , List<String> path , List<List<String>> res){
        if(idx == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx; i<s.length(); i++){
            if(ispal(s, idx , i)){
                path.add(s.substring(idx , i+1));
                func(i+1 , s , path , res);
                path.remove(path.size()-1);
            }
        }
    }

    static boolean ispal(String s , int start , int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(partition(s));


    }
}
