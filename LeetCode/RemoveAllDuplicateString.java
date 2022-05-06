package LeetCode;

import java.util.Stack;

/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
You are given a string s and an integer k,
a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them,
 causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"


Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.
 */
public class RemoveAllDuplicateString {
    public static void main(String[] args){
        String s = "pbbcggttciiippooaais";
        System.out.println(removeDuplicates(s ,2));


    }
    public static String removeDuplicates(String s, int k) {

        Stack<int[]> main = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!main.isEmpty() && main.peek()[0] == ch){
                main.peek()[1]++;
            }else{
                main.push(new int[]{ch,1});
            }
            if(main.peek()[1] == k) main.pop();
        }

        StringBuilder str = new StringBuilder();
        while(main.size() >0){
            int[] top = main.pop();
            while(top[1]-->0) str.append((char) top[0]);
        }
        return str.reverse().toString();
    }
}
