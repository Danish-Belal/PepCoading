package InterviewQ_BS;
/*
Let's call an array arr a mountain if the following properties hold:
Q - . find peak in mountant array

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain,
 return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].



Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1
 */
public class Mountant_Array {
    public static void main(String[] args) {
        int[]  arr = {0,1 , 2,6,1,0};
       int ans= peakIndexInMountainArray(arr);
        System.out.println(ans);

    }


    public static int peakIndexInMountainArray(int[] arr) {
        int st = 0;
        int end = arr.length-1;

        while(st < end){
            int mid = st + (end-st)/2;
            if(arr[mid] > arr[mid+1]){
                // You may be in decreasing part of Array.
                //this may be the ans but look at the left
                //this is why end!= mid-1;
                end = mid;
            }else {
                st = mid+1;  // we know that mid+1 element > mid element.
            }
        }
        // Here start ans end both will point to middle element.
        // Start and end always trying to find max in two checks.
        // hence when they are pointing to same element that is the max element.
       return end;
    }

}
