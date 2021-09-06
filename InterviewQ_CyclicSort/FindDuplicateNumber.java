package InterviewQ_CyclicSort;
/*
https://leetcode.com/problems/find-the-duplicate-number/submissions/
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3
 */
public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[]nums = {1,3,4,2,2};
        int ans = findDuplicate(nums);
        System.out.println(ans);

    }

    public static int findDuplicate(int[] nums) {
        int i = 0 ;
         while(i < nums.length){

             if(nums[i] != i+1){
                int correctidx = nums[i] - 1;
                if (nums[i] != nums[correctidx]) {
                 swap( nums , i , correctidx);
                }else{
                    return nums[i];
             }}else{
                 i++;
             }
         }
//         int ans = 0 ;
//         for(int idx = 0 ; idx<nums.length ; idx++){
//             if(nums[idx] != idx+1){
//                 ans = nums[idx];
//             }
//         }
//     return  ans;
        return -1;
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}

