package InterviewQ_CyclicSort;
import java.util.*;

/*
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
Given an array nums of n integers where nums[i] is in the range [1, n],
 return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
 */

public class AllMIssingNumber {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
       List<Integer> i = findDisappearedNumbers(arr);
       for(int element  : i){
           System.out.println(element);
       }


    }
    public static List<Integer> findDisappearedNumbers(int[] arr) {

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
                    ans.add(index+1);
                }
            }

       return  ans;
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
