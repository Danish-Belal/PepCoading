package Recursion_on_the_Way_up;

import java.util.Scanner;
/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner.
 Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of pri tMazePath function - without changing signature -
to print the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Constraints
0 <= n <= 10
0 <= m <= 10

Sample Input
2
2

Sample Output
hv
vh

 */
public class PritMazePath {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int dr = in.nextInt();
        int dc = in.nextInt();
        String psf= "";
        printMazePaths(0,0,dr-1,dc-1 ,psf );

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sc == dc && sr == dr) {
            System.out.println(psf);
            return;

        }
        if(sc>dc ||sr>dr){
            return;
        }
        printMazePaths(sr , sc+1 , dr , dc , psf+"h");
        printMazePaths(sr+1 , sc , dr , dc , psf+"v");

    }
}
