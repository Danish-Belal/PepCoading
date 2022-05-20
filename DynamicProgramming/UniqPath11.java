package DynamicProgramming;

public class UniqPath11 {
    public static void main(String[] args){
        int[][] grid2 = {
                {0,0,1},
                {0,0,0}
        };

       // System.out.println(uniquePathsWithObstacles(grid2));
        System.out.println(uniquePathsWithObstaclesDP(grid2));
    }
    static int step;
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        step = 0;
        path(obstacleGrid , 0,0,obstacleGrid.length-1 , obstacleGrid[0].length-1 );
        return step;
    }
    static void path(int[][] grid , int sr , int sc , int dr , int dc ){

        if(sr > dr || sc > dc) return;

        if(grid[sr][sc] == 1) return;

        if(sr == dr && sc == dc) {
            step++;
            return;
        }
        path(grid , sr+1 ,sc , dr,dc );
        path(grid , sr , sc+1 , dr ,dc );
    }

    public static  int uniquePathsWithObstaclesDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0 ; i<m ; i++){
            if(grid[i][0] == 1) break;
            else{
                dp[i][0] = 1;
            }
        }

        for(int i = 0 ; i<n ; i++){
            if(grid[0][i] == 1) break;
            else{
                dp[0][i] = 1;
            }
        }

        for(int i =1 ; i<m; i++){
            for(int j = 1 ; j<n ; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];


    }
}
