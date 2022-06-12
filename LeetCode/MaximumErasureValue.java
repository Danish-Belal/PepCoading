package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/*

https://leetcode.com/problems/maximum-erasure-value/

You are given an array of positive integers nums and want to erase a subarray containing unique elements.
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a,
 that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:
Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

 */
public class MaximumErasureValue {
    public static void main(String[] args){
        int[] arr = {6,5,3,5,7,1,2,3,7,9,8,5};
        System.out.println(maximumUniqueSubarray( arr));

    }
    public static int maximumUniqueSubarray(int[] nums) {

        int[] preSum = new int[nums.length];

        preSum[0] = nums[0];

        for(int i =1 ; i<nums.length;i++){
            preSum[i] = preSum[i-1]+nums[i];
        }

        System.out.println(Arrays.toString(preSum));
        HashMap<Integer,Integer> mp = new HashMap<>();

        int stIdx = 0;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i =0 ; i<nums.length;i++){
            if(mp.containsKey(nums[i])){
                if(mp.get(nums[i])>=stIdx){
                    stIdx = mp.get(nums[i])+1;
                    currSum = preSum[i]-preSum[mp.get(nums[i])];
                    mp.put(nums[i] , i);
                }
            }else{
                currSum += nums[i];
                mp.put(nums[i] , i);
            }
            maxSum = Math.max(currSum , maxSum);
        }
        return maxSum;

    }

}
