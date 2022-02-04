package HashMap_Heap;

import java.util.HashMap;
/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContigiousSubArray {
    public  int findMaxLength(int[] nums) {
        int longsubArray =0;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i =0 ; i < nums.length ; i++){

            sum += nums[i] == 0 ? -1: 1;

            if(map.containsKey(sum)){
                if( i - map.get(sum) > longsubArray){
                    longsubArray =  i - map.get(sum);
                }
            }else{
                map.put(sum , i);
            }
        }
        return longsubArray;
    }
    public static void main(String[] args){
       int[] arr = {0,1,0,1,0,0,1,1,0,0};
      //  System.out.println(findMaxLength(arr));
        ContigiousSubArray obj = new ContigiousSubArray();
        int ans = obj.findMaxLength(arr);
        System.out.println(ans);
    }
}

