/*
1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to multiply n1 and n2 and print the value.

2 <= b <= 10
0 <= n1 <= 10000
0 <= n2 <= 10000

Sample Input
5
1220
31

Sample Output
43320

*/

#include<bits/stdc++.h>
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


int baseMul(int b, int n1, int d2)
{
     int ans = 0;
     int power =1;
     int carry = 0;

     while( n1 !=0 ||  carry !=0){
          int l1 = n1%10;
        
          n1 /=10;
         

          int mul = l1*d2+carry;
          int q = mul/b;
          int r = mul%b;

          carry = q;
          ans += r *power;
          power *= 10;

     }
     return ans;
}
int getproduct(int b, int n1 , int n2)
{
  int ans =0;
  int power = 1;
  while (n2 !=0)
  {
    int d2 = n2%10;
    n2 /=10;

    int sprd = baseMul(b , n1 , d2);
    ans = baseAddition(b , ans , sprd*power);
    power *=10;
  }
  return ans;

}
int main()
{
  int b, n1 ,n2;
  cin>>b>>n1>>n2;
  cout<<getproduct(b,n1,n2);


  return 0;
}