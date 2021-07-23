/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the span of input.
 Span is defined as difference of maximum value and minimum value.

Constraints

1 <= n <= 10^4
0 <= n1, n2
 .. n elements <= 10 ^9

Sample Input

6
15
30
40
4
11
9

Sample Output

36
*/

#include<bits/stdc++.h>
using namespace std;
int max1 = INT_MIN ;
int min1 = INT_MAX ;
int main()
{
     int n;
     cin>>n;
     int arr[n];

     for(int i=0;i<n;i++){
          cin>>arr[i];
     }
     // int max1 = 0;
     // int min1 = 10e+10;

     for(int i=0;i<n;i++){
      max1 =    max(max1 , arr[i]);
      min1 =    min(min1 , arr[i]);
     }
     cout<<max1-min1;


  return 0;
}