package LeetCode;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args){
        int[] nums1 = {5,6,7,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1,3,nums2 , 3);
        System.out.println(Arrays.toString(nums1));

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1 , i = m+n-1;

        while(p2 >=0 ){
            if(p1 >=0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            }else{
                nums1[i--] = nums2[p2--];
            }
        }
    }
}
