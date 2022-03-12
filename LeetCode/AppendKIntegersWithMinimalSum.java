package LeetCode;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {
    public static void main(String[] args){
        int[] arr = {1,4,25,10,25};
        int k = 2;
        System.out.println(minimalKSum(arr , k));

    }

    public static long minimalKSum(int[] nums, int k) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        long ct = 0;

        int i = 1;
        int r = 0;

        while(k != 0){
            if(nums[r] != i) ct+=i;
            i++;
            r++;
            k--;
        }
        return ct;

    }
}
