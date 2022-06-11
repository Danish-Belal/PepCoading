package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubString {
    public static void main(String[] args){
       String s = "abcdeabcd";
       System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {

        Map<Character , Integer> mp = new HashMap<>();

        int maxLen = Integer.MIN_VALUE;
        for(int i = 0 ; i<s.length();i++){
            char ch = s.charAt(i);
            if(mp.containsKey(ch)){
                if(mp.size() > maxLen) maxLen = mp.size();
                mp.remove(ch);
            }else{
                mp.put(ch , 1);
            }
        }
        return maxLen;

    }
}
