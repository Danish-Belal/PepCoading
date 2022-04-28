package Recursion2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't
                   force you but intends you to teach a concept.
 */
public class Permutation {
    public static void permutations(int[] boxes, int ci, int ti){
        // write your code here
        if(ci >ti){
            for(int i = 0 ; i<boxes.length ;i++){

                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }

        for(int i =0; i<boxes.length; i++){

            if(boxes[i] ==0){
                boxes[i] = ci;
                permutations(boxes , ci+1 , ti);
                boxes[i] = 0;

            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }
}
