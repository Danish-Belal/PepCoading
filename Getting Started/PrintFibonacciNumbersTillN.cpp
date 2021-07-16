/*
1. You've to print first n fibonacci numbers.
2. Take as input "n", the count of fibonacci numbers to print.
3. Print first n fibonacci numbers.

*/
#include <bits/stdc++.h>
using namespace std;

int main()
{
     int n;
     cin >> n;
     int st = 0;
     int st1 = 1;
     cout<<st<<endl<<st1<<endl;
     for(int i = 1; i < n-1 ; i++){
          int next = st+st1;
          cout<<next<<endl;
          st = st1;
          st1 = next;
     }

     return 0;
}