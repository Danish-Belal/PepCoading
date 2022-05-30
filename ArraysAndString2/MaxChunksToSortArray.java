package ArraysAndString2;

import java.util.Arrays;

/*
https://leetcode.com/problems/max-chunks-to-make-sorted/
You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them,
 the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.
 */
public class MaxChunksToSortArray {
    public static void main(String[] args){

    }

    public static  int maxChunksToSorted(int[] arr) {
        int chunks = 0 ;

        int maxIdx = Integer.MIN_VALUE;

        for(int i = 0 ; i<arr.length ; i++){

            maxIdx = Math.max(maxIdx , arr[i]);

            if(i == maxIdx){
                chunks++;
            }

        }

        return chunks;
    }

    //https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
    public int maxChunksToSorted2(int[] nums) {
        int[] maxLeft = new int[nums.length];
        int[] minRight = new int[nums.length+1];

        minRight[nums.length] = Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0 , j = nums.length-1 ; i<nums.length && j>=0 ; i++,j--){
            max = Math.max(max , nums[i]);
            maxLeft[i] = max;

            min = Math.min(min , nums[j]);
            minRight[j] = min;
        }

        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(minRight));
        int chunks = 0;

        for(int i =0 ; i<nums.length ; i++){
            if(maxLeft[i] <= minRight[i+1]) chunks++;
        }

        return chunks;
    }

    // Without using two array
    public int maxChunksToSorted3(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE;


        for(int i = n-1 ; i>=0 ; i--){
            rightMin[i] = Math.min(nums[i] , rightMin[i+1]);
        }

        int chunks = 0;
        int leftMax = Integer.MIN_VALUE;
        for(int i =0 ; i<n ; i++){
            leftMax = Math.max(nums[i] , leftMax);

            if(leftMax <= rightMin[i+1]) chunks++;
        }
        return chunks;
    }
}
