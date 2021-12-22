package SelfCode.Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner.
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..)
            or 1 or more steps diagonally (as d1, d2, ..).
4. Complete the body of getMazePath function - without changing signature -
        to get the list of all paths that can be used to move from top-left to bottom-right.
        Use sample input and output to take idea about output.

Constraints

0 <= n <= 10
0 <= m <= 10

Sample Input

2
2

Sample Output

[h1v1, v1h1, d1]
 */
public class GetMazeWithJump {
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePaths(0,0,n-1, m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc){
            return new ArrayList<>();
        }
        if(sc == dc && sr == dr){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> rr1 = getMazePaths(sr , sc+1 , dr , dc);
        ArrayList<String> cc1 = getMazePaths(sr+1 , sc, dr , dc);
        ArrayList<String> dd1 = getMazePaths(sr+1 , sc+1 , dr , dc);

        ArrayList<String> mr = new ArrayList<>();

        for (String i : rr1){
            mr.add("h1"+i);
        }
        for (String i : cc1){
            mr.add("v1"+i);
        }
        for (String i : dd1){
            mr.add("d1"+i);
        }
        return mr;

    }
}
