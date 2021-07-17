/*
1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Constraints

1 <= n <= 44

Sample Input

5

Sample Output

1	
2	3	
4	5	6	
7	8	9	10	
11	12	13	14	15

*/

#include<bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin>>n;
     int num =1;
     for(int i =1; i<=n ; i++){
          for(int j =1 ; j<=i ; j++){
               cout<<num<<"\t";
               num++;
          }
          cout<<endl;
     }

  return 0;
}