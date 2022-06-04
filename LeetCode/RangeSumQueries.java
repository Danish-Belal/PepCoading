package LeetCode;

/*
https://leetcode.com/problems/range-sum-query-2d-immutable/
Given a 2D matrix matrix, handle multiple queries of the following type:

Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner
    (row1, col1) and lower right corner (row2, col2).
Implement the NumMatrix class:

NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the
    rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
    NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

 */
public class RangeSumQueries {
    public static void main(String[] args){

    }
    // This is give TLE.
    int[][] matrix;
    public void NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0 ;
        for(int i = row1 ; i<= row2 ; i++){
            for(int j = col1 ; j<= col2 ; j++){
                sum += matrix[i][j];
            }
        }
        return sum;

    }
}

