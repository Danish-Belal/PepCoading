/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.

Asssumption - Array is sorted. Array may have duplicate values.

Constraints

1 <= n <= 1000
1 <= n1, n2, .. n elements <= 100
1 <= d <= 100

Sample Input

15
1 5 10 15 22 33 33 33 33 33 40 42 55 66 77
33

Sample Output

5
9
*/

#include<bits/stdc++.h>
using namespace std;

void firstAndLast(int *arr , int n , int d){
     int fi = -1;

     int l = 0;
     int r = n-1;

     while(r >=l){
          int  mid = l+(r-l)/2;
          if(arr[mid] == d ){
               fi = mid;
               r = mid-1;

          }else if(arr[mid] < d){
               l = mid+1;

          }else{
               r = mid-1;

          }
     }
      
     int li = -1;

      l = 0;
      r = n-1;

     while(r >=l){
          int  mid = l+(r-l)/2;
          if(arr[mid] == d ){
               li = mid;
               l = mid+1;

          }else if(arr[mid] < d){
               l = mid+1;

          }else{
               r = mid-1;

          }
     }
     cout<<fi<<endl<<li;
}

int main()
{
     int n;
     cin>>n;
     int arr[n];
     for(int i = 0 ; i<n ; i++){
          cin>>arr[i];
     }
     int d;
     cin>>d;
    
    firstAndLast(arr ,n , d);

  return 0;
}