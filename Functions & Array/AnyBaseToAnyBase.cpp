/*
1. You are given a number n.
2. You are given a base b1. n is a number on base b.
3. You are given another base b2.
4. You are required to convert the number n of base b1 to a number in base b2.

Constraints
0 <= n <= 512
2 <= b1 <= 10
2 <= b2 <= 10

Sample Input
111001
2
3

Sample Output
2010

*/

#include <bits/stdc++.h>
using namespace std;
int ToAnyBase(int n, int b1, int b2);
int main()
{
     int n, b1, b2;
     cin >> n >> b1 >> b2;

     long long int ans = ToAnyBase(n, b1, b2);
     cout << ans;

     return 0;
}

int ToAnyBase(int n, int b1, int b2)
{
     int dans = 0, bans = 0;
     int p = 0;

     int n1 = n;
     // Converting anybase into decimal.
     while (n > 0)
     {
          int r = n % 10;

          int power = pow(b1, p);
          dans += r * power;

          n /= 10;
          p++;
     }
     // cout << dans << endl;
     n1 = dans;

     // In dsan Decimal value of given BasedValue is Present.
     // Converting AnyBase to Decimal.

     int p1 = 1;
     while (n1 > 0)
     {

          int r = n1 % b2;
          n1 /= b2;

          bans += r * p1;

          p1 *= 10;
     }

     
     return bans;
}
