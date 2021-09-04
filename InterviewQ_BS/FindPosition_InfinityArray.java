package InterviewQ_BS;
/*
Suppose you have a sorted array of infinite numbers, how would you search an element in the array?
Source: Amazon Interview Experience.
Since array is sorted, the first thing clicks into mind is binary search,
but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key,
 first we find bounds and then apply binary search algorithm.

Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.

 */

public class FindPosition_InfinityArray {
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 3;

        System.out.println(ans(arr,target));
    }

    static int ans(int[] arr , int target){
        // First find the Range
        //first start with the box size 2.
        int st = 0 ;
        int end = 1;


//        // Condition for the target lies in the range.
        if(target > arr[end]){
            int newst = end+1;    // This is my new Start
            // Double the size of box.
            end = end + (end-st +1) *2;
            st = newst;


        }


        // GFG solution .
//        int key = arr[0];
//        while (key < target){
//            st = end;
//            if(2*end < arr.length-1){
//                end = 2*end;
//            }else{
//                end = arr.length-1;
//            }
//            key = arr[end];
//
//        }
        return binarySearch(arr,target,st,end);
    }

    static  int binarySearch(int[] arr ,  int target , int lo , int hi){

        while( hi >=lo)    {
            int mid = lo + (hi-lo) / 2;
            if (target < arr[mid]) {
                hi = mid-1;
            } else if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
