package DynamicProgramming;

public class UniqPath11 {
    public static void main(String[] args){
        int[][] grid2 = {
                {0,0,1},
                {0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(grid2));
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
}
