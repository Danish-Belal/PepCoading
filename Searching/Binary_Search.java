package Searching;
/*
write a binary search to return index of given target .
of tagert is not present return -1.


 */
public class Binary_Search {
    public static void main(String[] args) {
        int[] arr= {1,4,6,7,8,9};
        int target = 90;
        int ans = binarySearch(arr , target);
        System.out.println(ans);

    }
    static  int binarySearch(int[] arr ,  int target){
        int lo = 0 ;
        int hi = arr.length-1;

        while(lo <= hi)    {
                int mid = lo + (hi-lo) / 2;
                if (target > arr[mid]) {
                    lo = mid+1;
                } else if (target < arr[mid]) {
                    hi = mid - 1;
                } else {
                     return mid;
                }

        }
        return -1;
    }
}
