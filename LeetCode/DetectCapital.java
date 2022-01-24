package LeetCode;
/*
https://leetcode.com/problems/detect-capital/
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.



Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 */
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        char ch = word.charAt(0);
        String ros = word.substring(1);
        char ch2 = ros.charAt(0);

        if(ch >= 'A' && ch <= 'Z'){
            if(ch2 >='A' && ch2 <= 'Z'){
                for(int i = 0; i<ros.length(); i++){
                    char c = ros.charAt(i);
                    if(! Character.isUpperCase(c))return false;

                }
            }else{
                for(int i = 0; i<ros.length(); i++){
                    char  c = ros.charAt(i);
                    if(!Character.isLowerCase(c ))return false;

                }
            }

        }else {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!Character.isLowerCase(c)) return false;

            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "USA";
        System.out.println(detectCapitalUse(s));
    }
}
