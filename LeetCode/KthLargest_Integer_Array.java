package LeetCode;

import java.util.*;

/*
https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/
You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.

Return the string that represents the kth largest integer in nums.

Note: Duplicate numbers should be counted distinctly. For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.



Example 1:

Input: nums = ["3","6","7","10"], k = 4
Output: "3"
Explanation:
The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
The 4th largest integer in nums is "3".
Example 2:

Input: nums = ["2","21","12","1"], k = 3
Output: "2"
Explanation:
The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
The 3rd largest integer in nums is "2".
 */
public class KthLargest_Integer_Array {
    public static String kthLargestNumber(String[] nums, int k) {
        Set<String> S = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add(nums[0]);
        for(int i = 1 ; i<k ; i++){


        }


return "";


    }
    public static void main(String[] args){
        String[] arr = {"3","6","7", "6" , "3" , "8"};
        int k = 4;
        String ans =  kthLargestNumber(arr ,k );
      //  System.out.println(ans);

    }
}
