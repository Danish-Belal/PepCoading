package InterviewQ_CyclicSort;
// https://leetcode.com/problems/first-missing-positive/
/*
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
Example 1:
Input: nums = [1,2,0]
Output: 3

Example 2:
Input: nums = [3,4,-1,1]
Output: 2

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1

 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[]  nums = {1,2,0};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);

    }
    public  static int firstMissingPositive(int[] arr) {
        int i = 0 ;
        while(i < arr.length){
            int correctidx = arr[i] -1;
            if( arr[i] > 0 && arr[i] <arr.length && arr[i] != arr[correctidx]){
                swap(arr , i , correctidx);
            }else {
                i++;
            }
        }
        // Checking for missing element.
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] != j+1){
                return j+1;
            }


        }
        return arr.length;

    }
    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
