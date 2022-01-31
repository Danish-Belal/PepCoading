package CodeForces;

import java.util.Scanner;

public class DivisibleBy7 {
    public static void divide(int n){
        if(n%7 == 0){
            System.out.println(n);
            return;
        }


        for(int i =n%7 ; i<=9 ; i++){
            n = n/10;
            n *=10;
            n += i;
            if(n%7 == 0){
                System.out.println(n);
                return;
            }
        }

        for(int i =1 ; i<n%7 ; i++){
            n = n/10;
            n *=10;
            n += i;
            if(n%7 == 0){
                System.out.println(n);
                return;
            }
        }

    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t !=0){
            int n = scn.nextInt();
            divide(n);
            t--;
        }
    }
}
