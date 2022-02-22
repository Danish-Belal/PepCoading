package SelfCode.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class TargetSumSubset {

    public static void main(String[] args) throws Exception {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0 ;i <n ; i++){
//            arr[i] = scn.nextInt();
//        }
//        int target = scn.nextInt();
//        printTargetSumSubsets(arr , 0 , "", 0 , target );


        // For Array.
        int[] arr = {1,2,1};
        int t = 2;
       // printSub(arr , 0 , 0, new ArrayList<>() , t);

        // For Printing only one Subsequence whose sum is Equal to target.
       // printSubone(arr , 0 , 0, new ArrayList<>() , t);

        // For ttl number of subsequences.
        System.out.println(tsubseq(arr , 0 , 0 , t));

    }

    // set is the subset
    // sos is sum of subset
    // tar is target

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }

        printTargetSumSubsets(arr , idx+1 , set+arr[idx]+", " , sos+arr[idx] , tar);
        printTargetSumSubsets(arr , idx+1 , set , sos , tar);


    }

    // Print only one subsequence.
    private static void printSub(int[] arr, int idx, int sum ,  ArrayList<Integer> ans, int t) {

        if(idx == arr.length){
            if(sum == t) System.out.println(ans);
            return;
        }

        // Not pick.
        printSub(arr , idx+1 , sum , ans , t);

        ans.add(arr[idx]);
        printSub(arr , idx+1 , sum+arr[idx] , ans , t);
        ans.remove(ans.size()-1);

    }
    private static boolean printSubone(int[] arr, int idx, int sum ,  ArrayList<Integer> ans, int t) {

        if(idx == arr.length){
            if(sum == t) {
                System.out.println(ans);
                return true;
            }
            else return false;

        }

        // Not pick.
        if(printSubone(arr, idx + 1, sum, ans, t)) return true;

        ans.add(arr[idx]);
        sum +=  arr[idx];
        if(printSubone(arr, idx + 1, sum , ans, t)) return true;

        ans.remove(ans.size()-1);
        return false;

    }



    // print total number of Subsequences.
    static int tsubseq(int[] arr , int idx , int sum , int t){
        if(idx == arr.length){
            if(sum == t) return 1;
            else return 0;
        }

        int l = tsubseq(arr , idx+1 , sum , t);
        int r = tsubseq(arr , idx+1 , sum+arr[idx] , t);
        return l+r;
    }

}
