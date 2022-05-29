package ArraysAndString2;

import java.util.Scanner;

public class MaxProductOfThreeNumber {
    public static int maximumProduct(int[] nums) {
        // write your code here
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int i = 0 ;

        while(i < nums.length){
            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }

            if(nums[i] < min1){
                min2= min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                min2 = nums[i];
            }


            i++;
        }
        // System.out.println(max1);
        //  System.out.println(max2);
        //  System.out.println(max3);
        //  System.out.println(min1);
        //  System.out.println(min2);

        return Math.max((max1*max2*max3) , (min1*min2*max1));
    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//
//        for(int i = 0; i < n; i++) {
//            arr[i] = scn.nextInt();
//        }

        int prod = maximumProduct(new int[]{-10,-20,3,45,6,8});
        System.out.println(prod);
    }
}
