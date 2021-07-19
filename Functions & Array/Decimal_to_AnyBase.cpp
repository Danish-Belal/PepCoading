// Convert Decimal To anyBase b/w 1-10
#include <bits/stdc++.h>
using namespace std;
int DecimalToAnyBase(int n, int b);
int main()
{
     int n, b;
     cin >> n >> b;

     long long int ans = DecimalToAnyBase(n, b);
     cout << ans;

     return 0;
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
