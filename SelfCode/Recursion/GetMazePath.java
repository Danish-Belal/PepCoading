package SelfCode.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc){
            return new ArrayList<>();
        }

        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }


        ArrayList<String> ss1 = getMazePaths(sr , sc+1 , dr, dc);
        ArrayList<String> sc1 = getMazePaths(sr+1 , sc , dr, dc);


        ArrayList<String> mr= new ArrayList<>();
        for(int i = 0 ; i< ss1.size() ; i++){
            mr.add("h"+ss1.get(i));
        }
        for(int i = 0 ; i< sc1.size() ; i++){
            mr.add("v"+sc1.get(i));
        }

        return mr;

    }

}
