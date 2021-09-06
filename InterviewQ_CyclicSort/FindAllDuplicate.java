package InterviewQ_CyclicSort;
import java.util.*;
/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n]
 and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]
 */
public class FindAllDuplicate {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer>ans = findDuplicates(nums);
        for (int element : ans){
            System.out.println(element);
        }


    }
    public static List<Integer> findDuplicates(int[] arr) {
        int i = 0 ;
        while(i < arr.length){
            int correctidx = arr[i]-1;
            if( arr[i] != arr[correctidx]){
                swap(arr , i , correctidx);
            }else {
                i++;
            }
        }

        List<Integer> ans= new ArrayList<>();
        for(int index = 0;index<arr.length;index++){
            if (arr[index] != index+1 ) {
                ans.add(arr[index]);
            }
        }

        return  ans;

    }
    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
