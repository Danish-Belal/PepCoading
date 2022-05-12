package LeetCode;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/permutations-ii/
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 */
public class Permutation2 {
    public static void main(String[] args){
        int[] nums = {1,1,2};

        System.out.println(permuteUnique(nums));

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result , nums , 0);
        return result;
    }
    static void backtrack( List<List<Integer>> result , int[] nums , int start){
        if(start == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int i : nums) curr.add(i);

            result.add(new ArrayList(curr));
            return;
        }else{
            for(int i = start ; i < nums.length ; i++){
                if(start != i && !canPermute(start , i , nums)) continue;  // check if value is not equal
                swap(i , start , nums);
                backtrack(result , nums , start+1);
                swap(start , i , nums);
            }
        }
    }

    static void swap(int i , int j , int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    static boolean canPermute(int start , int curr , int[] nums){
        for(int i = start ; i<curr ; i++){
            if(nums[i] == nums[curr]) return false;
        }
        return true;
    }
}
