package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LargestNumber {

    public static String largestNumber(int[] nums) {

        String s = "";
        for(int i : nums){
            s += i;
        }

       // System.out.println(s);
        char[] ch = s.toCharArray();

        Arrays.sort(ch);
        int i = 0 ;
        int j = ch.length-1;

        while(i<j){
            char c1 = ch[i];
            ch[i] = ch[j];
            ch[j] = c1;
            i++;
            j--;
        }




        return String.valueOf(ch);
    }

    public static void main(String[] args){
        int[]  nums = {10,2};
        String ans = largestNumber(nums);
        System.out.println(ans);
    }
}
