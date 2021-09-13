package Recursion;

public class RecursionInBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 8;
        System.out.println(search(arr , target , 0 , arr.length-1));


    }
    public static int search(int[] arr , int target  , int s , int e){

        if(s > e){
            return -1;
        }
        int mid = s+ (e-s)/2;
        if(arr[mid] == target){
            return  mid;
        }
        if(arr[mid] < target){

           return search(arr , target , mid+1 , e);
        }else{
            return  search(arr, target , s , mid-1);
        }
    }
}
