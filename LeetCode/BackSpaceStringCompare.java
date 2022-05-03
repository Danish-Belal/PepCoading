package LeetCode;

import java.util.Stack;

/*
https://leetcode.com/problems/backspace-string-compare/

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true

 */
public class BackSpaceStringCompare {
    public static void main(String[] args){
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s,t));

    }
    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(s1.size() == 0) continue;
                s1.pop();
            }
            else{
                s1.push(s.charAt(i));
            }
        }

        for(int i = 0 ; i<t.length();i++){
            if(t.charAt(i) == '#') {
                if(t1.size() == 0) continue;
                t1.pop();
            }else{
                t1.push(t.charAt(i));
            }
        }

        // System.out.println(s1.peek());
        //  System.out.println(t1.peek());

        while(s1.size() > 0 && t1.size() > 0){
            if(s1.pop() != t1.pop())return false;
        }

        if(s1.size() == 0 && t1.size()==0) return true;
        return false;

    }
}
