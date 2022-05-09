package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 */
public class LetterCombinatioinPhone {
    public static void main(String[] args){
        System.out.println(LatterCombination("23"));

    }
    static String[] codes = {".;" , "" , "abc" , "def" , "ghi", "jkl","mno","pqrs", "tuv","wxyz",};

    static List<String> LatterCombination(String str){
        List<String> combi = new ArrayList<>();
        if(str.length() ==0) return combi;
        helper(str , 0 , combi , new StringBuilder());
        return combi;
    }
    static void helper(String str , int i  , List<String> combi , StringBuilder s){
        if( i == str.length()){
            combi.add(s.toString());
            return;
        }
       String code = codes[str.charAt(i)-'0'];

        for(int k = 0 ; k<code.length() ; k++){
            s.append(code.charAt(k));
            helper(str , i+1 , combi , s);
            s.deleteCharAt(s.length()-1);
        }

    }
}
