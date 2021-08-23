/*
1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner.
Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature -
to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Constraints

0 <= n <= 10
0 <= m <= 10

Sample Input

3
3

Sample Output

[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
 */

package RecursionWithArrayList;
import java.lang.reflect.Array;
import java.util.*;
public class GetMazePath {
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
        if(sr == dr && sc==dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;

        }
        if(sc > dc || sr >dr){
            return new ArrayList<> ();

        }



        ArrayList<String> rr1 = getMazePaths(sr , sc+1 , dr , dc);
        ArrayList<String> cc1 = getMazePaths(sr+1 , sc , dr , dc);

        ArrayList<String> mr = new ArrayList<>();
        for (String value : rr1) {
            mr.add("h" + value);
        }

        for (String s : cc1) {
            mr.add("v" + s);
        }

        return mr;
    }
}
