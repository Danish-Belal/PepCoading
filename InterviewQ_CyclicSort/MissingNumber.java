package InterviewQ_CyclicSort;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/missing-number/
/*
Given an array nums containing n distinct numbers in the range [0, n],
return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?



Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
2 is the missing number in the range since it does not appear in nums.

Example 3:
Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9].
8 is the missing number in the range since it does not appear in nums.

Example 4:
Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1].
1 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1};
        int mNo=  missingNumber(arr);
        System.out.println(mNo);
        System.out.println(Arrays.toString(arr));
    }

     static int missingNumber(int[] arr) {
        int i = 0 ;
        while(i < arr.length){
            int correctidx = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correctidx]){
                swap(arr , i , correctidx);
            }else {
                i++;
            }
        }
        // Checking for missing element.
         for (int j = 0; j < arr.length; j++) {
             if(arr[j] != j){
                 return j;
             }


         }
     return arr.length;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


    // Approach 2.
    // Find alls element sum and minus it from ttl sum . you will get the ans.
    public int missingNumber2(int[] nums) {

        int n = nums.length;
        int tSum =( n*(n+1))/2;

        int numsSum = 0;
        for(int i : nums){
            numsSum +=i;
        }

        return tSum-numsSum;

    }
}
