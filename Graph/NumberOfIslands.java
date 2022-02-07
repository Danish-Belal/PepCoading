package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1. You are given a 2d array where 0's represent land and 1's represent water.

     Assume every cell is linked to it's north, east, west and south cell.

2. You are required to find and count the number of islands.
Constraints

None
Format
Input

Input has been managed for you
Output

Number of islands
Example

Sample Input

8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

Sample Output

3


 */
public class NumberOfIslands {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        boolean[][] visited = new boolean[m][n];

        int ct = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr[0].length ; j++){
                if(arr[i][j] == 0 && visited[i][j] == false){
                    isLand(arr , visited , i , j);
                    ct++;
                }
            }
        }
        System.out.println(ct);
    }

    static void isLand(int[][] arr , boolean[][] visited , int i , int j){

        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 1 ) return;

        visited[i][j] = true;

        isLand(arr , visited , i , j+1);
        isLand(arr , visited , i+1 , j);
        isLand(arr , visited , i , j-1);
        isLand(arr , visited , i-1 , j);
    }

}
