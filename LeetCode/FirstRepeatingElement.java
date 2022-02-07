package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

/*
Given an Array of size N . Find first repeating element in Array , and index of first occurence is smallest.
Constrains .

0<= N <= 10^6.
0<= Ai <= 10^6

sample input:
7
1  5 3 4 3 5 6
sample output:
2
Element 3 , 5 Appear twice but 5's index is smaller than 3.
 */
public class FirstRepeatingElement {

    static int N = (int)1e6+2;

    public static int minIdxofRepeat(int[] arr){

        HashMap<Integer , Integer> map = new HashMap<>();
        int minidx = Integer.MAX_VALUE;

        for(int i = 0 ; i<arr.length ; i++){
            if(map.containsKey(arr[i])){
                minidx = Math.min(minidx , map.get(arr[i]));
            }else{
                map.put(arr[i] , i);
            }
        }

        return minidx == Integer.MAX_VALUE ? -1 : minidx+1;
    }
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n ; i++){
            arr[i] = scn.nextInt();
        }



        //Approach1 by making a big array.
//
//        int[] repet = new int[N];
//        for(int i = 0 ; i<N ; i++){
//            repet[i] = -1;
//        }
//        int minidx = Integer.MAX_VALUE;
//
//        for(int i = 0 ; i<n ; i++){
//            if(repet[arr[i]] != -1){
//                minidx = Math.min(minidx , repet[arr[i]]);
//            }else{
//                repet[arr[i]] = i;
//            }
//        }
//
//        if(minidx == Integer.MAX_VALUE){
//            System.out.println(-1);
//        }else{
//            System.out.println(minidx+1);
//        }


        // Approach2 , using Hash Map.
      int ans =  minIdxofRepeat(arr);
        System.out.println(ans);

    }
}
