package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.



Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109

 */
public class MaxKsumPair {
    public static void main(String[] args){

    }
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        int count = 0;

        for(int x : nums){
            mp.put(x , mp.getOrDefault(x , 0)+1);
        }

        for(int i : mp.keySet()){
            if(mp.containsKey(i) && mp.containsKey(k-i)){
                if(i != k-i){
                    count += Math.min(mp.get(i) , mp.get(k-i));
                    mp.put(i ,0);
                    mp.put(k-i , 0);
                }else{
                    count += Math.floor(mp.get(i)/2);
                    mp.put(i , 0);
                }
            }
        }
        return count;

    }
    public int maxOperations2(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        int count =0;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum == k){
                left++;
                right--;
                count++;
            }
            else if(sum > k){
                right--;
            }else{
                left++;
            }
        }
        return count;

    }
}
