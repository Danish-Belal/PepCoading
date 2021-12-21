package SelfCode.Recursion;

import java.util.ArrayList;

public class GetStairsPath {
    public static void main(String[] args) throws Exception {
        System.out.println(getStairPaths(4));

    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n  == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;

        }
        if(n < 0){
            return new ArrayList<>();
        }

        ArrayList<String> mr = new ArrayList<>();

//        ArrayList<String> rr1 = getStairPaths(n-1);
//        for (int i = 0 ;i<rr1.size() ; i++){
//            mr.add( "1" +rr1.get(i) );
//
//        }
//        ArrayList<String> rr2 = getStairPaths(n-2);
//        for (int i = 0 ;i<rr2.size() ; i++){
//            mr.add( "2" +rr2.get(i) );
//
//        }
//        ArrayList<String> rr3 = getStairPaths(n-3);
//        for (int i = 0 ;i<rr3.size() ; i++){
//            mr.add( "3" +rr3.get(i) );
//
//        }

        // Can also solved by itrative method.
        for(int jump = 1 ; jump <= 3 && n-jump >= 0 ; jump++){
            ArrayList<String> rr = getStairPaths(n-jump);
            for (int i = 0 ; i<rr.size() ; i++){
                mr.add(jump+rr.get(i));
            }
        }
        return mr;

    }
}
