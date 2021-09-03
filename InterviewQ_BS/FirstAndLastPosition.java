package InterviewQ_BS;

import java.util.Arrays;

/*
Given an array of integers nums sorted in ascending order,
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 */
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(nums , target);
        System.out.println(Arrays.toString(ans));

    }


    public  static  int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int st = search(nums , target , true);
        int end = search(nums , target , false);

        ans[0] = st;
        ans[1] = end;
        return  ans;


    }
    static int search(int[] nums , int target , boolean findfirstindex){
        int ans =-1;
        int st = 0;
        int end = nums.length-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(target <nums[mid]){
                end = mid-1;
            }else if(target > nums[mid]){
                st = mid+1;
            }else{
                // We got our potential ans .
                ans = mid;
                if(findfirstindex){
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }
        }
        return ans;
    }
}
