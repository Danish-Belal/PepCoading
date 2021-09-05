package Sorting_Algos;
// Bubble sort is also known as sinking sort / Exchange sort.
// In each itration largest element in unsorted array goest to last position.
// Time complexity :
// If array is already sorted then this is the best case --> o(N).
// If array is sorted in decreasing order then this is worst case --> o(N^2)

import java.util.Arrays;

public class Bubble_sort {
    public static void main(String[] args) {
        int arr[] = {-1,7,0,-32,89};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }



   public static void  bubbleSort(int[] arr){
        // For every iteration .
        for(int i = 0 ; i<arr.length ;i++){
            boolean isswapped = false;

            // For each stpe i , max element will come at the last respective index.
            for(int j = 1 ; j<arr.length -i ; j++){

                // Swap item if item is smaller than privios item.
                if(arr[j-1] > arr[j] ){

                   swap(arr , j-1 , j);
                   isswapped = true;
                }
            }
            if(!isswapped){
                System.out.println("Array is alreay sorted.");
                break;
            }
        }

    }
    public static  void swap(int[] arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
