package Searching;

public class RihestCoustmerWelth_leet {
    public static void main(String[] args) {
        int[][] acc = {
                {1, 2, 3}, {3, 2, 1}
        };
        int ans = maximumWealth(acc);
        System.out.println(ans);


    }

    public static int maximumWealth(int[][] accounts) {
        int ans = 0;
        for (int[] ints : accounts) {
            int rsum = 0;
            for (int anInt : ints) {
                rsum += anInt;
            }
            if (rsum > ans) {
                ans = rsum;
            }
        }
        return ans;

    }

}
