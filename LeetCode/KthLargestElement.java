package LeetCode;

import java.util.PriorityQueue;
/*
https://leetcode.com/problems/kth-largest-element-in-an-array/
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.



Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 */
public class KthLargestElement {
    public int findKthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<k ; i++){
            pq.offer(arr[i]);
        }

        for(int i = k ; i<arr.length ; i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        return pq.poll();
    }
}
