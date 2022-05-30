package ArraysAndString2;

/*
https://leetcode.com/problems/product-of-array-except-self/
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptItself {
    public static void main(String[] args){

    }
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        long mul = 1 ;
        int zeroCount = 0;
        for(int val : nums){
            if(val == 0) zeroCount++;
            else{
                mul *= val;
            }
        }
        if(zeroCount > 1){
            return ans;
        }

        if(zeroCount == 1){
            int i = 0;
            while(nums[i] != 0){
                i++;
            }
            ans[i] = (int) mul;
            return ans;

        }else{
            for(int i = 0  ; i<nums.length ; i++){
                ans[i] = (int) mul/nums[i];
            }
        }
        return ans;
    }

    // By using two array.
    // for an index product will me left product of i-1 , and right product of i+1 will be at ans[i].
    public int[] productExceptSelf2(int[] nums) {

        int n = nums.length;
        int[] leftP = new int[n];
        int[] rightP = new int[n];

        leftP[0] = nums[0];
        rightP[n-1] = nums[n-1];

        for(int i = 1  , j = n-2 ; i<n && j>=0  ; i++,j--){
            leftP[i] = leftP[i-1]*nums[i];
            rightP[j] = rightP[j+1]*nums[j];
        }

        int[] ans = new int[n];
        ans[0] = rightP[1];
        ans[n-1] = leftP[n-2];
        for(int i =1 ; i<n-1 ; i++){
            ans[i] = leftP[i-1]*rightP[i+1];
        }

        return ans;
    }
}
