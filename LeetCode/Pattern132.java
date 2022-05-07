package LeetCode;

import java.util.Stack;

/*
https://leetcode.com/problems/132-pattern/
Given an array of n integers nums,
 a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.



Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
 */
public class Pattern132 {
    public static void main(String[] args){
        int[] arr = {1,2,3,2};
        System.out.println(find132pattern(arr));
        System.out.println(find132Pattern2(arr));

    }
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        int leftMin = nums[0];
        for(int j = 1 ; j<n-1 ; j++){
            for(int k = j+1 ; k<n ; k++){
                if(nums[k] > leftMin && nums[j] > nums[k]){
                    return true;
                }
            }
            leftMin = Math.min(nums[j] , leftMin);
        }
        return false;

    }
    // o(n) Complexity.
    static boolean find132Pattern2(int[] nums){
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i =1 ; i<nums.length ; i++) min[i] = Math.min(min[i-1] , nums[i]);

        Stack<Integer> stck = new Stack<>();

        for(int j = nums.length-1 ; j>=0 ; j--){
            while(stck.size() > 0 && stck.peek() <= min[j]) stck.pop();
            if(stck.size()>0 && stck.peek() < nums[j]) return true;
            stck.push(nums[j]);
        }
        return false;

    }
}
