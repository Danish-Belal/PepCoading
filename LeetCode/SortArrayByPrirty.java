package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://leetcode.com/problems/sort-array-by-parity/
iven an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.



Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

 */
public class SortArrayByPrirty {
    public static void main(String[] args){
        int[] nums = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));


    }
    public static int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for(int i =0 ; i<nums.length ; i++){
            if(nums[i] %2 == 0){
                even.add(nums[i]);
            }else{
                odd.add(nums[i]);
            }
        }

        for(int i = 0 ; i<even.size() ; i++){
            nums[i] = even.get(i);
        }

        for(int i = 0 ; i<odd.size() ; i++){
            nums[even.size()+i] = odd.get(i);
        }
        return nums;

    }



}
