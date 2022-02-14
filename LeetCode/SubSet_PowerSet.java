package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets/
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

 */
public class SubSet_PowerSet {
    List<List<Integer>> result ;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.result = new ArrayList<List<Integer>>();
        this.nums = nums;

        compute( 0 , new ArrayList<>());
        return result;

    }

    private void compute(int i , ArrayList<Integer> l){
        if(i == nums.length){
            result.add(new ArrayList<>(l));
            return ;
        }
        compute(i+1 , l);
        l.add(nums[i]);
        compute(i+1 , l);
        l.remove(l.size()-1);
    }
}
