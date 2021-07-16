/*
1. You've to display the digits of a number in reverse.
2. Take as input "n", the number for which digits have to be display in reverse.
3. Print the digits of the number line-wise, but in reverse order.

*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
   int n;
     cin >> n;
    
     while (n > 0)
     {
          int ld = n % 10;
        
          cout << ld << endl;
          n /= 10;
     }
   
  return 0;
}