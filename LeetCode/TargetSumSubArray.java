package LeetCode;

import java.util.Arrays;

/*
Given an array and target ,
 return first and last index if contagious subArray sum is equal to target.

 sum = 12;
 arr = 1,2,3,7,5

 output = 2,3

 */
public class TargetSumSubArray {
    public static int[] targetSum(int[] arr , int target){

        int st =-1 , en = -1 , i = 0 , j=0 , sum = 0;

        while(j < arr.length){

            if(sum < target){
                sum += arr[j];

            }else if(sum == target){
                st = i;
                en = j-1;
                break;
            }else {
                sum -= arr[i];
                i++;
                if(sum == target) {
                    st = i;
                    en = j-1;
                    break;
                }
            }
            j++;

        }
        return new int[]{st , en};

    }

    public static void main(String[] args){
        int[] arr = {1,2,3,8,5};
        int sum = 4;

        int[] ar1= targetSum(arr , sum);
        System.out.println(Arrays.toString(ar1));
    }
}
