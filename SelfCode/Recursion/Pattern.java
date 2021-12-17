package SelfCode.Recursion;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        pattern(n);
    }
    public static void pattern(int n){
        if(n == 0) return;
        System.out.print(n+" ");
        pattern(n-1);
        System.out.print(n+" ");
        pattern(n-1);
        System.out.print(n+" ");
    }
}
