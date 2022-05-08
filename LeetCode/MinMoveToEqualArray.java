package LeetCode;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.



Example 1:

Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinMoveToEqualArray {
    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(minMoves(arr));

    }

    // make all element equal to smaller
    public static int minMoves(int[] nums) {
        int small = nums[0];
        int sum = 0;
        for(int i : nums){
            sum += i;
            if(i < small) small = i;
        }
        return (sum - nums.length*small);
    }

    // MinMove2 . you can increase or decrease an element by 1 .
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
    public int minMoves2(int[] nums) {
        int n = nums.length;

        // Sort the Array.
        Arrays.sort(nums);

        // Find The Median.
        int median = n%2 == 0 ? (nums[n/2] + nums[n/2-1])/2 : nums[n/2];

        int step  =0 ;
        for(int i : nums)
            step += Math.abs(i-median);

        return step;
    }
}
