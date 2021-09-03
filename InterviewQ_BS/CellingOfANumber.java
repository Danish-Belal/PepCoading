package InterviewQ_BS;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/*
Celling of number means you have given an array and a target
 celling --> the smallest element in array greater or = target.   -->return arr[lo]

 floor --> the greatest number in array  smaller or = targer.  --> return arr[hi].
 */
public class CellingOfANumber {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16 ,18};
        int target =10;

        int ans= celling(arr ,target);
        System.out.println(ans);

    }

    static int celling(int [] arr , int target){
        int lo = 0 ;
        int hi = arr.length-1;

       if(target > arr[arr.length-1]){
           return  -1;
       }

        while(lo <= hi)    {
           int  mid = lo + (hi-lo) / 2;
            if (target > arr[mid]) {
                lo = mid+1;
            } else if (target < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }

        }
        return arr[lo];
      //  return arr[hi]   // for floor

    }
}
