/*
1. You are given a number n, representing the number of rows and columns of a square matrix.
2. You are given n * n numbers, representing elements of 2d array a. 
Note - Each row and column is sorted in increasing order.
3. You are given a number x.
4. You are required to find x in the matrix and print it's location int (row, col) format as discussed in output format below.
5. In case element is not found, print "Not Found".

Constraints

1 <= n <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9
All rows and columns are sorted in increasing order

Sample Input

4
11 12 13 14
21 22 23 24
31 32 33 34
41 42 43 44

43

Sample Output

3
2
*/

#include<bits/stdc++.h>
using namespace std;

int main()
{
     int n;
     cin>>n;
     int arr[n][n];
     for(int i= 0 ; i< n ; i++){
          for(int j = 0 ; j< n ;j++){
               cin>>arr[i][i];
          }
     }
     
     int data;
     cin>>data;
     


  return 0;
}