package RecursionWithArrayList;
import java.util.*;
/*
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step,
   2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature -
     to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Constraints
0 <= n <= 10
Sample Input
3
Sample Output
[111, 12, 21, 3]

 */


public class GetStairPath {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getStairPaths(n));

    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n<0){
            return new ArrayList<>();
        }
        if(n==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;

        }
        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> ss1 = getStairPaths(n-1);

        for(int i = 0 ; i< ss1.size() ; i++){
            mr.add("1" + ss1.get(i));
        }
        ArrayList<String> ss2 = getStairPaths(n-2);
        for(int i = 0 ; i< ss2.size() ; i++){
            mr.add("2" + ss2.get(i));
        }
        ArrayList<String> ss3 = getStairPaths(n-3);
        for(int i = 0 ; i< ss3.size() ; i++){
            mr.add("3" + ss3.get(i));
        }



        return mr;
    }
}
