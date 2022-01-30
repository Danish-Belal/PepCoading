package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/sliding-window-maximum/
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.



Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
 */
public class Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] arr, int k) {

    PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
    int[] ans = new int[arr.length-k+1];
    int r = 0;

    for(int i = 0 ; i<k ; i++){
        Q.offer(arr[i]);
    }

    ans[r++] = Q.peek();
    for(int i = k ; i<arr.length ; i++){
        if(arr[i] >= Q.peek()){
            ans[r++] = arr[i];
            Q.add(arr[i]);
        }else{
            Q.add(arr[i]);
            ans[r++] = Q.peek();
        }
    }
        return ans;
}
    public static void main(String[] args){
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maxSlidingWindow(arr , k);
        System.out.println(Arrays.toString(ans));
    }

}
