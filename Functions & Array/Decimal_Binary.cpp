// Conversion of Decimal to Binary.

#include <bits/stdc++.h>
using namespace std;
int binaryToDecimal(int n);
int main()
{
     int n;
     cin >> n;
     long long int ans = binaryToDecimal(n);
     cout << ans;

     return 0;
}

int binaryToDecimal(int n)
{
     int ans = 0;
     int pow = 1;

     while (n > 0)
     {
          int r = n % 2;
          n /= 2;

          ans += r * pow;

          pow *= 10;
     }
     return ans;
}
