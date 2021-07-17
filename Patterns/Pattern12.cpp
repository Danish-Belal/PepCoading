/*

1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

input
5

Sample Output

0	
1	1	
2	3	5	
8	13	21	34	
55	89	144	233	377	
*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin>>n;
     int a = 0;
     int b=1; 
     for(int i =0 ; i<n ;i++){
          for(int j= 0 ; j<=i ; j++){
               cout<<a<<"\t";
               int c = a+b;
               a = b;
               b=c;

          }
          cout<<endl;

     }

  return 0;
}