package InterviewQ_CyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You have a set of integers s, which originally contains all the numbers from 1 to n.
 Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
  which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:
Input: nums = [1,1]
Output: [1,2]
 */
public class SetMissmatch {
    public static void main(String[] args) {
        int[] nums=  {8,7,3,5,3,6,1,4};
        int[] ans = findErrorNums(nums);
        System.out.println(Arrays.toString(ans));


    }
    public static  int[] findErrorNums(int[] arr) {
        int[] ans = new int[2];
        int i = 0 ;
        while(i < arr.length){
            int correctidx = arr[i]-1;
            if( arr[i] != arr[correctidx]){
                swap(arr , i , correctidx);
            }else {
                i++;
            }
        }


        for(int index = 0;index<arr.length;index++){
            if (arr[index] != index+1 ) {
                ans[0] = arr[index];
                ans[1] = index+1;
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
