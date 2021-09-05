package Sorting_Algos;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            int minidx = i;
            for(int j = i+1 ; j<arr.length ; j++){
                if(isSmaller(arr , j , minidx)){
                    minidx = j;
                }
            }
            swap(arr , i , minidx);
        }
    }
    public static boolean isSmaller(int[] arr , int i , int j){
        return arr[i]<arr[j];
    }
    public  static  void swap(int[] arr , int  i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
