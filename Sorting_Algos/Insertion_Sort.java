package Sorting_Algos;

import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] arr = {-34,5,7,0,-76,45};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void insertionSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(nums[j] < nums[j-1]){
                    swap(nums , j-1 , j);
                }else{
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr , int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
