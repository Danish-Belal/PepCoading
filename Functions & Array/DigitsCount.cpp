/*
1. You are given a number n.
2. You are given a digit d.
3. You are required to calculate the frequency of digit d in number n.

Constraints

0 <= n <= 10^9
0 <= d <= 9
  

Sample Input

994543234
 4

Sample Output

3


*/
#include <bits/stdc++.h>
using namespace std;

int digitCount(int n, int r)
{
     int ct = 0;

     while (n > 0)
     {

          int r1 = n % 10;
          if (r1 == r)
          {
               ct++;
          }

          n = n / 10;
     }
     return ct;
}

int main()
{
     long long int n;
     cin >> n;
     int digit;
     cin >> digit;
     int d = digitCount(n, digit);
     cout << d << endl;

}