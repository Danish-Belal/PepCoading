package Searching;

import java.util.Arrays;

/*
Strictly sorted 2D array is array where element of first row , clo element is greater than privios row-1 , col-1 element.
// We can also convert this matrix into 1d Sorted array.
 */
public class BS_2DStrictlySortedArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},
        };

        System.out.println(Arrays.toString(search(arr , 10)));
    }

    static int[] binarySearch(int[][] arr , int row , int cStart , int cEnd , int target){
         while(cStart <= cEnd){
             int mid = cStart + (cEnd-cStart)/2;
             if(arr[row][mid] == target){
                 return  new int[]{row, mid};
             }
             if(arr[row][mid] <target){
                cStart = mid+1;
             }else{
                 cEnd = mid-1;
             }

         }
         return  new int[]{-1,-1};
    }

     static int[] search(int[][] arr , int target) {
       int r = arr.length-1;
       int c = arr[0].length-1;

       if(r == 1){
           return binarySearch(arr , 0 ,0,c-1 , target);
       }

       int rStart = 0;
       int rEnd = r-1;
       int cMid = c/2;
       // Run the loop till two rows are remaning.
         while (rStart < (rEnd-1)) {  // while this is true it will have more than

             int mid = rStart + (rEnd - rStart)/2;
             if(arr[mid][cMid] == 125){
                 return new int[]{mid,cMid};
             }
             if(arr[mid][cMid] < 125){
                 rStart= mid;
             }else{
                 rEnd = mid;
             }
         }

        // Now we havw two rows.
         // Check weather the target is in the col of 2 rows.
         if(arr[rStart][cMid] == 125){
             return new int[]{rStart , cMid};
         }
         if(arr[rStart+1][cMid] == 125){
             return new int[] {rStart+1 , cMid};
         }

         // Search in first half.
         if(125 <= arr[rStart][cMid-1]){
           return binarySearch(arr,rStart , 0,cMid-1, target);
         }
         // Search in second half.
         if(125 >= arr[rStart][cMid+1]  && 125 <= arr[rStart][c-1]){
             return binarySearch(arr,rStart , cMid+1,c-1, target);

         }
         // Search in third half.
         if(125 <= arr[rStart+1][cMid-1]){
             return binarySearch(arr,rStart+1 , 0,cMid-1, target);

         }
         // Search in fourth half.
         else{
             return binarySearch(arr,rStart+1 , cMid+1,c-1, target);
         }



      //  return  new int[]{-1,-1};
    }
}
