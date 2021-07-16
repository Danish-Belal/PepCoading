/*
1. You are required to check if a given set of numbers is a valid pythagorean triplet.
2. Take as input three numbers a, b and c.
3. Print true if they can form a pythagorean triplet and false otherwise.


Constraints
1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9

Sample Input
5 3 4

Sample Output
true

*/

#include<bits/stdc++.h>
using namespace std;
int main()
{
  long long int a,b,c;
  cin>>a>>b>>c;
  long long int max1  = max(a,b);
  long long int min1 = min(a,b);
  long long int max2  = max(max1,c);
  long long int min2 = min(max1 , c);
  if(max2*max2 == (min1*min1)+(min2*min2)){
       cout<<"true";
  }
  else{
       cout<<"false";
  }

  return 0;
}