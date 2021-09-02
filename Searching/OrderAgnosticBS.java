package Searching;
/*
In Order Agnostic Binary search we dnot know in which order Array is sorted.
 to check this take first and last element od Array and compare them.
 if s>e --> decreasing order
 if s<e --> increasing order.
 */
public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {9,6,6 ,5,3,2,1};
        //int[] arr= {1,4,6,7,8,9};
        int target = 2;
        int ans = binarySearch(arr ,target);
        System.out.println(ans);

    }
   static int binarySearch(int[] arr , int target) {
       int lo = 0;
       int hi = arr.length - 1;

       boolean isAodr = arr[lo] < arr[hi];

       while(lo <= hi)    {
           int mid = lo + (hi-lo) / 2;

           if(arr[mid] == target){
               return mid;
           }
           else if(isAodr){
               if (target > arr[mid]) {
                   lo = mid+1;
               } else  {
                   hi = mid - 1;
               }
           }else{
               if (target < arr[mid]) {
                   lo = mid+1;
               } else  {
                   hi = mid - 1;
               }
           }

       }
       return  -1;
   }
}
