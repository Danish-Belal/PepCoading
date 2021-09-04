package InterviewQ_BS;
/*
Consider an array of distinct numbers sorted in increasing order.
 The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Examples:
Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,6, 12, 15, 18}. We get the given array after
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0
 */
public class RotationCount {
    public static void main(String[] args) {
      int  arr[] = {7, 9, 11, 12, 15};
         int rotation = piviot(arr)+1 ;

        System.out.println(rotation);


    }

    static  int piviot(int[] arr){

        int st = 0;
        int end = arr.length-1;



        while(st <= end){
            int mid = st +(end-st)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return  mid;
            }else if(mid > st && arr[mid] < arr[mid-1]){
                return  mid-1;
            }else if(arr[st] > arr[mid]){
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return -1;
    }
}
