package LeetCode;

import java.util.Arrays;
/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 find two numbers such that they add up to a specific target number.
 Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
 */
public class TargetSum2 {

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(twoSum(arr , 7)));

    }
    public static int[] twoSum(int[] numbers, int target) {
        int i =0 ;
        int j = numbers.length-1;
        while(i<j){
            int currSum = numbers[i]+numbers[j];
            if(currSum > target) j--;
            else if(currSum < target) i++;
            else return new int[]{i+1, j+1};

        }
        return new int[]{};
    }
}
