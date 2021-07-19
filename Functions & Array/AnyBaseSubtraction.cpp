/*
1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to subtract n1 from n2 and print the value.

Constraints

2 <= b <= 10
0 <= n1 <= 256
n1 <= n2 <= 256

Sample Input

8
1
100

Sample Output

77


*/

#include <bits/stdc++.h>
using namespace std;
int AnyBaseDecimalTo(int n, int b)
{
     int ans = 0;
     int p = 0;

     while (n > 0)
     {
          int r = n % 10;

          int power = pow(b, p);
          ans += r * power;
          p++;
          n /= 10;
     }
     return ans;
}

int DecimalToAnyBase(int n, int b)
{
     int ans = 0;
     int pow = 1;

     while (n > 0)
     {
          int r = n % b;
          n /= b;

          ans += r * pow;

          pow *= 10;
     }
     return ans;
}

int baseSubtraction(int b, int n1, int n2)
{
     int n11 = AnyBaseDecimalTo(n1, b);
     int n22 = AnyBaseDecimalTo(n2, b);
     int sub = n22 - n11;

     return DecimalToAnyBase(sub, b);
}
int main()
{
     int b, n1, n2;
     cin >> b >> n1 >> n2;
     int sub = baseSubtraction(b, n1, n2);
     cout << sub;

     return 0;
}