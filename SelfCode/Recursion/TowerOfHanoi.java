package SelfCode.Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Assume we Are giving name of first tower 10 ans so on.
        toh(n,10,20,30);

    }

    public static void toh(int n, int t1id, int t2id, int t3id){
        if(n == 0 ) return;
        toh(n-1 , t1id , t3id , t2id);
        System.out.println(n + "[" + t1id + " -> " + t2id + "]" );
        toh(n-1 , t3id , t2id , t1id);
    }
}
