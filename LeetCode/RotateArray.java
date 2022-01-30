package LeetCode;
/*
https://leetcode.com/problems/rotate-array/

Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {

        rotatee(nums , k);

    }

    void rotatee(int[] nums , int k){
        int n = nums.length;
        k = k%nums.length;
        reverse(nums , 0 , n-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , n-1);
    }
    void reverse(int[] nums , int i , int j){
        while(j >= i){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
            i++;
        }
    }
    public static void main(String[] args){

    }

}

