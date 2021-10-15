package Recursioin_Pattern;

import java.util.Arrays;
import java.util.Collections;

/*
Pattern1 print this pattern using recursion.
* * * *
* * *
* *
*
Pattern2 print this pattern using recursion.
 *
 * *
 * * *
 * * * *
 */
public class Pattern1 {
    public static void main(String[] args) {
     pattern1(4);
     pattern12(4);

    }

    public static void pattern1(int n){
        if(n == 0){
            return;
        }
            for (int i = 1; i <= n; i++) {
                System.out.print("*" + " ");
            }
            System.out.println();

            pattern1(n-1);

    }
    static void pattern12(int n){
        if(n==0) return;

        pattern12(n-1);
        for(int i = 1 ; i<=n ; i++){
            System.out.print("*" + "" +"\t");
        }
        System.out.println();
    }



}
