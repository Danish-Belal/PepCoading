package Math;

import java.lang.reflect.Array;
/*
https://leetcode.com/problems/the-kth-factor-of-n/
 */
import java.util.*;

// All numbers which can completly divide a number is konwn as factor of that number.
public class Factors {
    public static void main(String[] args) {
       // Factor1(20);
       // Factor2(12);
        System.out.println(kthFactor(12, 3));   //Find kth Factor of a Number.

    }
    public static void Factor1(int n){    // Brute force Approach . o(N) Time Complexity
        for (int i = 1; i <= n; i++) {
            if(n%i == 0){
                System.out.print(i + " ");
            }
        }

    }
    public static void Factor2(int n){
        // For storing other half number in list.
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 1 ; i<= Math.sqrt(n) ; i++){
            if( n%i == 0){
                if(n/i == i){       // if it is perfect squre.
                    System.out.print(i + " ");

                }else {
                    System.out.print(i + " ");
                    l.add(n/i);
                }
            }
        }
        for (int i = l.size()-1; i >=0 ; i--) {
            System.out.print(l.get(i) +" ");
        }

        Collections.sort(l);  // Used to sort an list
    }

    public static int kthFactor(int n , int k){
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 1 ; i<= Math.sqrt(n) ; i++){
            if( n%i == 0){
                if(n/i == i){
                    l.add(i);

                }else {
                    l.add(i);
                    l.add(n/i);
                }
            }
        }

        Collections.sort(l);
        System.out.println();


        if(k > l.size()) return -1;
        return l.get(k-1);

    }
}
