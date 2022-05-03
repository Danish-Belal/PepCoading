package LeetCode;

/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class SortedUnSortedCOntiSub {
    public static void main(String[] arsg){
        int[] arr = {6,4,8,10,9};
        System.out.println(findUnsortedSubarray(arr));

    }
    public static  int findUnsortedSubarray(int[] nums) {
        int end = -1;
        int max = nums[0];

        for(int i =1 ; i<nums.length ;i++){
            if(max  > nums[i]){
                end = i;
            }else{
                max = nums[i];
            }
        }

        int st = 0;
        int min = nums[nums.length-1];

        for(int i = nums.length-1 ; i>=0 ; i--){
            if(min < nums[i]){
                st = i;
            }else{
                min = nums[i];
            }
        }
        return end-st+1;


    }
}
