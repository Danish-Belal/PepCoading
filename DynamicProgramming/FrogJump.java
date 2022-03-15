package DynamicProgramming;

public class FrogJump {
    public static void main(String[] args){
        int n = 5;
        int[] heights = {12,34,54,3,56,78};
        System.out.println(frogJump(n  , heights));
    }
    public static int frogJump(int n, int heights[]) {


        return jump2( n , heights );

    }
    static int Jump( int n , int[] heights , int[] dp){

        if( n == 0) return 0;

        if(dp[n] != 0) return dp[n];
        int l = Jump(n-1 , heights , dp) + Math.abs(heights[n] - heights[n-1]);
        int r = Integer.MAX_VALUE;
        if(n > 1)
            r = Jump(n-2 , heights , dp) + Math.abs(heights[n] - heights[n-2]);


        return dp[n] =  Math.min(l,r);

    }

    static int jump2(int n , int[] h){

        int[] dp = new int[n];
        dp[0] = 0;
        for(int i =1  ; i<n ; i++){
            int fs  = dp[i-1]+Math.abs(h[i] - h[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1 )
                ss = dp[i-2]+Math.abs(h[i] - h[i-2]);

            dp[i] = Math.min(ss , fs);
        }

        return dp[n-1];
    }
}
