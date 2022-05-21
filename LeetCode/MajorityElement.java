package LeetCode;

import java.util.Arrays;
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

    // o(nlogn) Time and o(1) space complexity.
    public static int majorityElement2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0 ; i<n ;){
            int val = nums[i];
            int lidx = i;

            while(lidx+1 <= n && nums[lidx] == val){
                lidx++;
            }
            if( lidx-i > n/2) return nums[i];
            i = lidx;
        }

        return 0;
    }

    // make a pair of unequal value . last remaning val will point to majority element.
    static int mooreVoatingAlgo(int[] nums){
        int n = nums.length;
        int val = nums[0];
        int count =1;

        for(int i = 1 ; i<n ; i++){
            if(nums[i] == val){
                count++;
            }else{
                if(count > 0){
                    // pair the unequal values so that reduce count value.
                    count--;
                }else{
                    // if count is not available then make current value as a val.
                    val = nums[i];
                    count = 1;
                }
            }
        }

        return val;
    }

    public static void main(String[] args){
       // int[] num = {1,1,2,2,2,3,3,3,5,6};
        int[] num = {10,10 , 30 ,30 , 30 , 30};

        //System.out.println(majorityElement(num));
      //  System.out.println(majorityElement2(num));   //o(nlogn) time and(1) space complexity.
        System.out.println(mooreVoatingAlgo(num));   //o(n) time and o(1) space complexity.
    }
}
