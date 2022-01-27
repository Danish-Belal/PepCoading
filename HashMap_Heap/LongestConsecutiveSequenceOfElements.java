package HashMap_Heap;

import java.util.HashMap;
import java.util.Scanner;
/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).
17
12  5 1 2 1 2 13 7 11 8 9 11 8 9 5 6 11

 */
public class LongestConsecutiveSequenceOfElements {
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int a1 = scn.nextInt();
        int[] arr1 = new int[a1];
        for (int i = 0; i < a1; i++) {
            arr1[i] = scn.nextInt();
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int  i : arr1){
            mp.put(i , 1);
        }

        for(int i : arr1){
            if(mp.containsKey(i-1)){
                mp.put(i , 0);
            }
        }
        //  System.out.println(mp);

        int Maxl = 1;
        int sp = arr1[0];
        for(int i : arr1){
            if(mp.get(i) == 1){
                int temp = i;
                int clen = 1;
                while(mp.containsKey(temp+1) ){
                    clen++;
                    temp++;
                }
                if(clen > Maxl){
                    Maxl = clen;
                    sp= i;
                }
            }
        }
        for(int i = sp ; i<= sp+Maxl ; i++){
            System.out.println(i);
        }
    }
}
