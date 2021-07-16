/*
1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
3. Take input "num1" and "num2" as the two numbers.
4. Print their GCD and LCM.


Constraints
2 <= n <= 10^9

Sample Input
36
24

Sample Output
12
72

*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
     int a , b;
     cin>>a>>b;
   int  n1 = a;
   int  n2 = b;
     int  gcd =1;
     while( a % b != 0){
           gcd = a%b;
          a= b;
          b = gcd;
     }
    
  cout<<gcd<<endl;
  int lcm = (n1*n2)/gcd;   // lcm = (num1*mun)/ gcd;
  cout<<lcm;
  return 0;
}