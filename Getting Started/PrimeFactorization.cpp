/*
1. You are required to display the prime factorization of a number.
    2. Take as input a number n.
    3. Print all its prime factors from smallest to largest.

Constrans
  2 <= n < 10 ^ 9

Sample Input
1440

Sample Output
2 2 2 2 2 3 3 5

*/

#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;

     for (int num = 2; num*num < n; num++)
     {
          while (n % num == 0)
          {
               n = n/ num;
               cout << num << " ";
          }

         
     }
     if(n != 1){
          cout<<n;
     }
     return 0;
}