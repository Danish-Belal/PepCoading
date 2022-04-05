package LeetCode;
/*
https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an ,
 where each represents a point at coordinate (i, ai).
  n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines,
   which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
Example 3:

Input: height = [4,3,2,1,4]
Output: 16
 */
public class ConatinerWithMostWater {
    public int maxArea(int[] arr) {

        int cw = 0;
        int max_water = Integer.MIN_VALUE;

        int i = 0;
        int j = arr.length-1;

        while(i < j){
            int idx = j-i;
            int min =  Math.min(arr[i] , arr[j]);
            cw = min*idx;
            if(cw > max_water){
                max_water = cw;
            }
            if(arr[i] < arr[j])  i++ ;
            else    j--;
        }
        return max_water;
    }
}
