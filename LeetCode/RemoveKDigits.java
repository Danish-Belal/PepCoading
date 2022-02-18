package LeetCode;

import java.util.Stack;
/*
https://leetcode.com/problems/remove-k-digits/submissions/
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.


Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (len == k) return "0";

        // **** initialization ****
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // **** populate the stack - O(n) ****
        for (int i = 0; i < len; i++) {

            // **** for ease of use ****
            char ch = num.charAt(i);

            // **** char in stack > ch in num (greedy selection) - O(k) ****
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                stack.pop();
                k--;
            }

            // **** push this character into the stack ****
            stack.push(ch);
        }

        // **** remove from stack characters (if needed) - O(k) ****
        for (; k > 0; k--) stack.pop();

        // **** move stack contents to string builder - O(n) ****
        while (!stack.isEmpty()) sb.append(stack.pop());

        // **** reverse string builder ****
        sb.reverse();

        // **** remove leading 0s from string builder - O(n) ****
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        // **** return string ****
        return sb.toString();
    }
}
