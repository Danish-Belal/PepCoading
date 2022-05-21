package LeetCode;

/*
https://leetcode.com/problems/squares-of-a-sorted-array/
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */
public class SqureOfSortedArray {

    public static void main(String[] args){

    }
    public int[] sortedSquares(int[] nums) {
        int i = 0 ;
        int j = nums.length-1;

        int[] ans = new int[nums.length];
        int r = ans.length-1;

        while(i <= j){
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[r] = Math.abs(nums[i]*nums[i]);
                i++;
            }else{
                ans[r] = Math.abs(nums[j]*nums[j]);
                j--;
            }
            r--;
        }
        return ans;

    }

    // 100% faster.
    public int[] sortedSquares2(int[] nums) {
        int i = 0 ;
        int j = nums.length-1;

        int[] ans = new int[nums.length];


        for(int k = ans.length-1 ; k >=0 ; k--){
            int val1 = nums[i]*nums[i];
            int val2 = nums[j]*nums[j];

            if(val1 > val2){
                ans[k] = val1;
                i++;
            }else{
                ans[k] = val2;
                j--;
            }

        }
        return ans;

    }
}
