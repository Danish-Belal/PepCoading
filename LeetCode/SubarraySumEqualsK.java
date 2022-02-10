package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */
public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {

        // Usnig prefix Sum.
//        int[] preSum = new int[nums.length];
//        preSum[0] = nums[0];
//
//        for(int i = 1 ; i<preSum.length ; i++){
//            preSum[i] = nums[i]+preSum[i-1];
//        }
//        System.out.println(Arrays.toString(preSum));
//
//        int count = 0;
//
//        for(int i = 0 ; i<preSum.length ; i++){
//            for(int j = i ; j<preSum.length ; j++){
//
//                if(i == 0){
//                    if(preSum[j] == k) count++;
//                }else{
//                    if(preSum[j]-preSum[i-1] == k) count++;
//                }
//            }
//        }
//
//        return count;

        // T.C = o(n^2) , space Complexity o(1)
//        int count = 0;
//        for(int i = 0 ; i<nums.length ; i++){
//            int sum = 0;
//            for(int j = i ; j<nums.length ; j++){
//                sum += nums[j];
//                if(sum == k) count++;
//            }
//        }
//        return count;

        // Using map.

        Map<Integer , Integer> map = new HashMap<>();
        map.put(0,1);


        int n = nums.length;
        int count = 0;
        int currSum = 0;

        for(int i = 0 ;i<n;i++){
            currSum += nums[i];

            if(map.containsKey(currSum-k)){
                count += map.get(currSum-k);
            }
            map.put(currSum , map.getOrDefault(currSum , 0 ) +1);

        }
        return count;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        int ans =subarraySum(arr , 3);
        System.out.println(ans);
    }
}
