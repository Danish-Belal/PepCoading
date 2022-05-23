package DynamicProgramming;

public class OnesAndZero {
    public static void main(String[] args){
        String[] strs = {"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs , 5,3));
    }

    // Memorization.
    static int[][][] dp;
    public static int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m+1][n+1][strs.length];
        return helper(strs , m , n , 0 );
    }
    static int helper(String[] strs , int zero , int one , int index){
        if(index == strs.length || zero+one == 0){
            return 0;
        }

        if(dp[zero][one][index] > 0) return dp[zero][one][index];
        int[] count = Count(strs[index]);

        int consider =0;
        if(zero >= count[0] && one >= count[1]){
            consider = 1+ helper(strs , zero-count[0] , one-count[1] , index+1);
        }
        int skip = helper(strs , zero, one , index+1);
        return dp[zero][one][index] =  Math.max(consider , skip);
    }

    // count the no of 0 and 1 in count.
    static int[] Count(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }
}
