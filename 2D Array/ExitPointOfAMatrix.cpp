/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
4. Consider this array a maze and a player enters from top-left corner in east direction.
5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.

Constraints

1 <= n <= 10^2
1 <= m <= 10^2
e1, e2, .. n * m elements belongs to the set (0, 1)

Sample Input

4
4
0 0 1 0
1 0 0 0
0 0 0 0
1 0 1 0

Sample Output

1
3
*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     int m ;
     cin>>n>>m;
     int arr[n][m];
     for(int i =0 ; i<n ; i++){
          for(int j =0 ; j<m ; j++){
               cin>>arr[i][j];
          }
     }

     

  return 0;
}