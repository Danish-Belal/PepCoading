package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.

Return the rearranged number with minimal value.

Note that the sign of the number does not change after rearranging the digits.



Example 1:

Input: num = 310
Output: 103
Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301, 310.
The arrangement with the smallest value that does not contain any leading zeros is 103.
Example 2:

Input: num = -7605
Output: -7650
Explanation: Some possible arrangements for the digits of -7605 are -7650, -6705, -5076, -0567.
The arrangement with the smallest value that does not contain any leading zeros is -7650.


Constraints:

-10^15 <= num <= 10^15

 */

public class SmallestValueOfRearrangeNumbers {

    public static  long smallestNumber(long num) {
        if(num == 0) return 0;
        String s = Long.toString(Math.abs(num));
        char[] ch = s.toCharArray();

        Arrays.sort(ch);
        if(num >=0){
            int i = 0 ;
            while(ch[i] == '0'){
                i++;
            }
            System.out.println(i);
            char temp = ch[i];
            ch[i] = '0';
            ch[0] = temp;
        }
        if(num <0){
            int i = 0 ;
            int j = ch.length-1;
            while(i <j){
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }


        }


//        for(char i : ch){
//            System.out.print(i+" ");
//        }
//        System.out.println(String.valueOf(ch));

        long ans = Long.parseLong(String.valueOf(ch));
        if(num < 0) return ans*-1;

        return ans;
    }

    public static void main(String[] args){
        long num = 310;
        long ans = smallestNumber(num);
        System.out.println(ans);
    }
}
