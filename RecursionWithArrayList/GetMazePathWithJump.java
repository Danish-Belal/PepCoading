package RecursionWithArrayList;
import java.util.*;
/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner.
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ),
 or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..).
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
public class GetMazePathWithJump {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr==dr &&sc==dc){
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> mr = new ArrayList<>();

        for(int jump = 1 ; jump <=dc-sc ; jump++){
        ArrayList<String> rr1 = getMazePaths(sr , sc+jump , dr,dc);
        for(String sr1 : rr1){

            mr.add("h"+jump+sr1);

        }}


        for(int jump = 1 ; jump <=dr-sr ; jump++){
        ArrayList<String> rc1 = getMazePaths(sr+jump , sc , dr,dc);
        for(String sc1 : rc1){

            mr.add("v"+jump+sc1);

        }}

        for(int jump = 1 ; jump <=dr-sr && jump <=dc-sc ; jump++){
            ArrayList<String> rc1 = getMazePaths(sr+jump , sc+jump , dr,dc);
            for(String sc1 : rc1){

                mr.add("d"+jump+sc1);

            }

        }

        return mr;
    }
}
