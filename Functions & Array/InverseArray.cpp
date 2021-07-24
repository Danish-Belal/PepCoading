/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to calculate the inverse of array a.

The only difference is the range of values is from 0 to n - 1, instead of 1 to n.

Constraints

0 <= n < 10^7
The only difference is the range of values is from 0 to n - 1, instead
of 1 to n

Sample Input

5
4
0
2
3
1

Sample Output

1
4
2
3
0

*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin>>n;
     int arr[n];
     int inversearr[n];
     for(int i=0 ; i<n ; i++){
          cin>>arr[i];
          inversearr[arr[i]] = i;

     }
     for(int i : inversearr){
          cout<<i<<endl;
     }

  return 0;
}