package ArraysAndString2;

import java.util.Arrays;
import java.util.Stack;

/*
https://leetcode.com/problems/next-greater-element-i/
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 */
public class NextGreaterElement {
    public static void main(String[] args){
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
      //  System.out.println(Arrays.toString(nextGreaterElement(nums1 , nums2)));
        System.out.println(Arrays.toString(nextGreaterElementStack(nums1 , nums2)));




    }

    // O(nums2.length)^3 Time Complexity.
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        if(nums2.length == 1){
            ans[0] = -1;
            return ans;
        }

        for(int r = 0; r<nums1.length ; r++){
            boolean check = false;
            int val = nums1[r];

            for(int i = 0 ; i<nums2.length ; i++){
                if(nums2[i] == val){
                    for(int k = i+1 ; k<nums2.length ; k++){
                        if(nums2[k] > val){
                            check = true;
                            ans[r] = nums2[k];
                            break;
                        }
                    }
                }
            }
            if(!check) ans[r] = -1;

        }
        return ans;
    }

    // using Stack.
    static int[] nextGreaterElementStack(int[] nums1 , int[] nums2){

        Stack<Integer> st = new Stack<>();
        int[] nextElement = new int[nums2.length];
        st.push(nums2[nums2.length-1]);
        nextElement[nums2.length-1] = -1;

        for(int i = nums2.length-2 ; i>=0 ; i--){
            if(st.peek() > nums2[i]){
                nextElement[i] = st.peek();
                st.push(nums2[i]);
            }else{
                while(st.size() > 0 && st.peek() < nums2[i]){
                    st.pop();
                }
                nextElement[i] = -1;
                st.push(nums2[i]);
            }
        }


        int[] ans = new int[nums1.length];
        for(int i = 0 ; i<nums1.length ; i++){
            for(int j = 0 ; j<nums2.length ; j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = nextElement[j];
                }
            }
        }
        return ans;
    }
}
