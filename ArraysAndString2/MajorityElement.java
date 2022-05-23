package ArraysAndString2;

import java.util.ArrayList;
import java.util.Scanner;

/*
https://leetcode.com/problems/majority-element-ii/

1. Given an integer array of size 'n'.
2. Find all elements that appear more than n / 3 times and return it in an arraylist.
3. Note : solve the problem in linear time and in O(1) space.
 */
public class MajorityElement {
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // write your code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Apply moore's voting algo for triplate.

        int ct1 =1,ct2 = 1;
        int val1= arr[0];
        int val2 = arr[1];

        for(int i = 2; i<n; i++){
            if(arr[i] == val1){
                ct1++;
            }else if(arr[i] == val2){
                ct2++;
            }else{
                if(ct1 >0 && ct2 >0){
                    ct1--;
                    ct2--;
                }else{
                    if(ct1 > 0){
                        ct2 = 1;
                        val2 = arr[i];
                    }else{
                        ct1 = 1;
                        val1 = arr[i];
                    }
                }
            }

        }
//        System.out.println(val1);
//        System.out.println(val2);

        ct1 = 0;
        ct2 =0;

        for(int i : arr){
            if(i == val1) ct1++;
            else if(i == val2) ct2++;
        }

        if(ct1 > n/3) ans.add(val1);
        if(ct2 > n/3) ans.add(val2);

        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}
