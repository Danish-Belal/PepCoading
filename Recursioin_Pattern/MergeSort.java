package Recursioin_Pattern;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
      int[] arr = {4,3,5,6,1,2 ,6,4};
       arr = marge(arr);
        System.out.println(Arrays.toString(arr));
    }

   public static int[] marge(int[] arr){
        if(arr.length == 1) {
            return arr;
        }

        int mid = arr.length/2;

        int[] left = marge(Arrays.copyOfRange(arr , 0 , mid));
        int[] right = marge(Arrays.copyOfRange(arr , mid , arr.length));

        return merdeg(left , right);

    }
    public static int[] merdeg(int[] first , int[] second){
        int[] mix = new int[first.length+second.length];

        int i =0 ;
        int j = 0 ;
        int k = 0;

        while(i < first.length && j< second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i<first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j<second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
