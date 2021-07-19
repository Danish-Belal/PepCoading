/*
1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to add the two numbes and print their value in base b.

Constraints
2 <= b <= 10
0 <= n1 <= 256
0 <= n2 <= 256

Sample Input
8
777
1

Sample Output
1000


*/

#include <bits/stdc++.h>
using namespace std;
int baseAddition(int b, int n1, int n2)
{
     int ans = 0;
     int power =1;
     int carry = 0;

     while( n1 !=0 || n2!=0 || carry !=0){
          int l1 = n1%10;
          int l2 = n2%10;
          n1 /=10;
          n2 /=10;

          int sum = l1+l2+carry;
          int q = sum/b;
          int r = sum%b;

          carry = q;
          ans += r *power;
          power *= 10;

     }
     return ans;
}
int main()
{
     int b, n1, n2;
     cin >> b >> n1 >> n2;
     int sum = baseAddition(b, n1, n2);
     cout << sum<<endl;


  
     return 0;
}