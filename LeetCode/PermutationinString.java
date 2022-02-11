package LeetCode;


import java.util.Arrays;

/*
https://leetcode.com/problems/permutation-in-string/
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 10^4
s1 and s2 consist of lowercase English letters.
 */
public class PermutationinString {
    public static  boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length() || s2.length() == 0) return false;
        if(s1.length()==0) return true;

        int[] fre1 = new int[26];
        int[] fre2 = new int[26];

        int  right  =0;
        while(right < s1.length()){
            fre1[s1.charAt(right)-'a'] +=1;
            fre2[s2.charAt(right)-'a'] +=1;
            right +=1;
        }

        System.out.println(Arrays.toString(fre1));
        System.out.println(Arrays.toString(fre2));

        for(int i = s1.length() ; i<s2.length();i++){
            if(Arrays.equals(fre1,fre2)) return true;
            fre2[s2.charAt(i-s1.length())-'a']--;
            fre2[s2.charAt(i)-'a']++;


        }
       return Arrays.equals(fre1,fre2);


    }

    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
