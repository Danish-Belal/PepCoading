/*
1. You are given two numbers n and k. You are required to rotate n,
 k times to the right. If k is positive, rotate to the right i.e.
  remove rightmost digit and make it leftmost. Do the reverse for negative value of k.
   Also k can have an absolute value larger than number of digits in n.
2. Take as input n and k.
3. Print the rotated number.
4. Note - Assume that the number of rotations will not cause leading 0's in the result.
 e.g. such an input will not be given
   n = 12340056
   k = 3
   r = 05612340

Constraints

1 <= n < 10^9
-10^9 < k < 10^9

Sample Input
562984
2

Sample Output
845629
*/

#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     int k;
     cin >> n >> k;
    
    int num = n;
    int ct =0;
    while(num !=0){
         num /=10;
         ct++;
    }

    k = k % ct;
    if(k < 0){
         k += ct;
    }
    cout<<k<<endl;
     int div =1;
     while(k>0){
          div *=10;
          k--;
     }
    cout<<div<<endl;

    int r = n % div;
    int q = n / div;
    
    
    int mul = (int) pow(10 , ct);
    cout<<mul<<endl;

    int newNum = (r*(mul/div)) + q;
    cout<<newNum<<endl;
    
  
     return 0;
}