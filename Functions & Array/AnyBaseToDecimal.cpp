// Convert Any Base Number into Decimal.

#include <bits/stdc++.h>
using namespace std;
int AnyBaseDecimalTo(int n, int b);
int main()
{
     int n, b;
     cin >> n >> b;

     long long int ans = AnyBaseDecimalTo(n, b);
     cout << ans;

     return 0;
}

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
