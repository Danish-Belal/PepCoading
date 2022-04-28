package Recursion2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without
                   changing signature. The judge can't force you but intends you to teach a concept.
 */
public class combination1 {
    public static void combinations(int cb, int tb, int ssf, int ts, String asf){
        // write your code here

        if(cb > tb){
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }

        combinations(cb+1 , tb , ssf+1 , ts , asf+"i");
        combinations(cb+1 , tb , ssf,ts,asf+"-");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
    }
}
