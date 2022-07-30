package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/word-subsets/
You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

 */
public class WordSubSet {
    public static void main(String[] args){
        String[] words = {"amazon","apple","facebook","google","leetcode"};
        String[] word2 = {"l","e"};
        System.out.println(wordSubsets2(words,word2));


    }
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();



       for(int i =0 ; i<words1.length ; i++){

           int[] w1 = new int[10];
           int[] w2 = new int[10];

           String s = words1[i];
           for(char c : s.toCharArray()) w1[c-'0']++;

           for(String s2 : words2){
               for(char c : s2.toCharArray()) w2[c-'0']++;
               int val =0;
               for(int j =0 ; j <10 ; j++){
                   if(w2[i] != 0 && w1[i] == 0) {
                       val = 1;
                       break;
                   }
               }
           }
       }

        return list;
    }

    public static  List<String> wordSubsets2(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        int[] target = new int[26];

        for(String s : words2){
            int[] temp = new int[26];

            for(char c : s.toCharArray()){
                temp[c-'a']++;
                target[c-'a'] = Math.max(temp[c-'a'] , target[c-'a']);
            }
        }

        for(String s : words1){
            int[] temp = new int[26];
            for(char c : s.toCharArray()) temp[c-'a']++;
            if(subset(temp , target)) ans.add(s);
        }
        return ans;
    }
    static boolean subset(int[] temp , int[] target){
        for(int i =0 ; i<26;i++){
            if(temp[i] < target[i]) return false;
        }
        return true;
    }
}
