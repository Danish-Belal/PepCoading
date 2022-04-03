package LeetCode;

import java.util.Arrays;
/*
https://leetcode.com/problems/next-permutation/
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 */
public class NextPermutation {
    public static void main(String[] args){
        int[] arr = {7,6,5,4,3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1) return ;
        int i = nums.length-2;
        while(i >=0 && nums[i] >= nums[i+1]) i--;
        if(i >=0){
            int j = nums.length-1;
            while(nums[i] >= nums[j]) j--;
            swap(nums , i , j);
        }
        reverse(nums , i+1 , nums.length-1);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void reverse(int[] nums, int i, int j) {
        while(i<j) swap(nums , i++ , j--);
    }
}
