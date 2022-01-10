package LeetCode;

import java.util.Arrays;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */
public class MedianofTwoSortedArrays {

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergerArray(nums1 , nums2);
        int l = merged.length;
        if(l%2 != 0){
            return merged[l/2];
        }else{
            int sum =  merged[l/2]+merged[(l/2)-1];
            return (double)(sum)/2;
        }

    }
    public static int[] mergerArray(int[] num1 , int[] num2){
        int[] ans = new int[num1.length+ num2.length];

        int i =0 ;
        int j = 0;
        int k = 0;

        while(i < num1.length && j<num2.length){
            if(num1[i] < num2[j]){
                ans[k] = num1[i];
                i++;
            }else{
                ans[k] = num2[j];
                j++;
            }
            k++;
        }

        while ( i < num1.length){
            ans[k] = num1[i];
            i++;
            k++;

        }
        while ( j < num2.length){
            ans[k] = num2[j];
            j++;
            k++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(Arrays.toString(mergerArray(num1,num2)));
        System.out.println(findMedianSortedArrays(num1 , num2));
    }
}
