package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/find-and-replace-pattern/submissions/
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x),
we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters:
every letter maps to another letter, and no two letters map to the same letter.

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

 */
public class FindAndReplacePattern {
    public static void main(String[] args){
       String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
       List<String> res =  findAndReplacePattern(words, "abb");
       System.out.println(res);
    }
    static List<String> ans;
    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        ans = new ArrayList<>();
        for(int  i = 0 ; i < words.length ; i++){
            String s = words[i];

            // Start compating .

            check(s, pattern);

        }
        return ans;
    }

    static void  check(String s  , String pattern){
        Map<Character , Character> mp = new HashMap<>();

        for(int i= 0 ; i<pattern.length() ; i++){
            if(mp.containsKey(pattern.charAt(i))){
                if(mp.get(pattern.charAt(i)) != s.charAt(i)) return ;

            }else{
                if(mp.containsValue(s.charAt(i))) return ;
                mp.put(pattern.charAt(i) , s.charAt(i));
            }
        }
        ans.add(s);
    }
}
