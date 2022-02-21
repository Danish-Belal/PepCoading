package LeetCode;

import java.util.HashMap;
import java.util.Map;
/*

https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
 You may assume that the majority element always exists in the array.
 Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        if(nums.length == 1) return nums[0];

        Map<Integer , Integer> mp = new HashMap<>();

        int maxfre = 0;
        int maxfrech = nums[0];

        mp.put(nums[0] , 1);
        for(int i = 1 ; i<nums.length ; i++){
            int ch = nums[i];
            mp.put( ch , mp.getOrDefault(ch , 0)+1);
            if(mp.get(ch) > maxfre){
                maxfre = mp.get(ch);
                maxfrech = ch;
            }
        }
        System.out.println(maxfrech);
        return maxfrech;
    }

    public static void main(String[] args){
       // int[] num = {1,1,2,2,2,3,3,3,5,6};
        int[] num = {10,10 , 30 ,30 , 30 , 30};

        System.out.println(majorityElement(num));
    }
}
