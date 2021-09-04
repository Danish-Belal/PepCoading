package InterviewQ_BS;
/*
https://leetcode.com/problems/find-in-mountain-array/
(This problem is an interactive problem.)

You may recall that an array A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
If such an index doesn't exist, return -1.

You can't access the mountain array directly.  You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.  Also,
 any solutions that attempt to circumvent the judge will result in disqualification.



Example 1:

Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: array = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
 */

public class FindInMountantArray {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,2,1 ,-1};
        int target = -1;

        int ans = search(arr,target);
        System.out.println(ans);

    }
    public static int search(int[] arr , int target){
        int high = pick(arr);
        int fhalf = binarySearch(arr,target ,0,high);
        if(fhalf != -1){
            return fhalf;
        }
        return binarySearch(arr,target , high+1 , arr.length-1);

    }

    public static int pick(int[] arr){
        int st = 0;
        int end = arr.length-1;

        while(st < end){
            int mid = st + (end-st)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }else {
                st = mid+1;  // we know that mid+1 element > mid element.
            }
        }

        return end;
    }

//    public static int findInMountainArray(int target, MountainArray mountainArr) {
//
//    }

    public static int binarySearch(int[] arr , int target , int lo , int hi) {

        boolean isAodr = arr[lo] < arr[hi];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (isAodr) {
                if (target > arr[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target < arr[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

        }
        return -1;
    }
}
