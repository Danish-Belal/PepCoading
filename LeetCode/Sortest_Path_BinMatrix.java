package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Sortest_Path_BinMatrix {
    public static void main(String[] args){
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
    }


    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});
        grid[0][0] = 1;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(q.size() > 0){
            int size = q.size();
            while(size-->0){
                int[] point = q.poll();

                if(point[0] == m-1 && point[1] == n-1)
                    return point[2];

                for(int[] d : dir){
                    int r = point[0]+ d[0];
                    int c = point[1]+d[1];

                    if(r >=0 && c>=0 && r<m && c<n && grid[r][c] == 0){
                        q.add(new int[]{r,c,point[2]+1});
                        grid[r][c] = 1;
                    }
                }
            }
        }
        return -1;

    }
}
