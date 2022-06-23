package LeetCode;

/*
https://leetcode.com/problems/trapping-rain-water/
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array
[0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TappingRainWater {

    public static void main(String[] args){
        int[] height = {1};
        System.out.println(trap(height));
    }

    // use maxLeft and MaxRight array .
    public static int trap(int[] h) {

        int[] leftMax = new int[h.length];
        int[] rightMax = new int[h.length];

        leftMax[0] = h[0];
        rightMax[h.length-1] = h[h.length-1];
        for(int i =1 , j = h.length-2 ; i<h.length && j >=0 ; i++ ,j--){
            leftMax[i] = Math.max(h[i] , leftMax[i-1]);
            rightMax[j] = Math.max(h[j] , rightMax[j+1]);
        }
        int tWater = 0;

        for(int i =0 ; i<h.length ; i++){
            tWater += (Math.min(leftMax[i] , rightMax[i]) - h[i]);
        }
        return tWater;
    }
}
