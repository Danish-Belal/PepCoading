package LeetCode;

/*
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.
 */
public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args){
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};
        System.out.println(minDominoRotations(tops , bottoms));


    }
    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int ct1 , ct2  , ct3 ,ct4;
        ct1 =ct2 =ct3 =ct4 = 0;



        for(int i =0 ; i<tops.length ; i++){
            // ct1 for making top row num1.
            int num1 = tops[0];
            if(ct1 != Integer.MAX_VALUE)    {
                    if (tops[i] == num1) {
                        // do nothing.
                    } else if (tops[i] != num1 && bottoms[i] == num1) {
                        ct1++;
                    } else {
                        ct1 = Integer.MAX_VALUE;
                    }
            }


            // ct2 for making top row num1.
            if(ct2 != Integer.MAX_VALUE)    {
                if(bottoms[i] == num1) {
                    // do nothing.
                } else if (bottoms[i] != num1 && tops[i] == num1) {
                    ct2++;
                } else {
                    ct2 = Integer.MAX_VALUE;
                }
            }

            // ct3 for making bottom row num2.
            int num2 = bottoms[0];
            if(ct3 != Integer.MAX_VALUE){
                if(bottoms[i] == num2){

                }else if(bottoms[i] != num2 && tops[i] == num2){
                    ct3++;
                } else{
                    ct3 = Integer.MAX_VALUE;
                }
            }

            if(ct4 != Integer.MAX_VALUE){
                if(tops[i] == num2){

                }else if(tops[i] != num2 && bottoms[i] == num2){
                    ct4++;
                }else{
                    ct4 = Integer.MAX_VALUE;
                }
            }

        }

        return Math.min(ct1 ,Math.min(ct2 , Math.min(ct3 , ct4)));

    }
}
