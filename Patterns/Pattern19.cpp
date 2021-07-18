/*
1. You are given a number n.
      2. You've to write code to print the pattern given in output format below
                                  
Constraints

1 <= n <= 10
 Also, n is odd.

Sample Input

3

Sample Output

*	*	*	
*	*	*	
*	*	*	

*/
#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;
     for (int i = 1; i <= n; i++)
     {
          for (int j = 1; j <= n; j++)
          {
               if (i == 1)
               { //First Row.
                    if (j <= n / 2 + 1 || j == n)
                    {
                         cout << "*\t";
                    }
                    else
                    {
                         cout << "\t";
                    }
               }

               else if (i <= n / 2)
               { // Upper Half
                    if (j == n / 2 + 1 || j == n)
                    {
                         cout << "*\t";
                    }
                    else
                    {
                         cout << "\t";
                    }
               }
               else if (i == n / 2 + 1)
               { // Middle
                    cout << "*\t";
               }
               else if (i > n / 2 + 1 && i < n)
               { // lower Middle Half
                    if (j == 1 || j == n / 2 + 1)
                    {
                         cout << "*\t";
                    }
                    else
                    {
                         cout << "\t";
                    }
               }
               else
               {
                    if (j == 1 || j >= n / 2 + 1)
                    {
                         cout << "*\t";
                    }
                    else
                    {
                         cout << "\t";
                    }
               }
          }
          cout << endl;
     }

     return 0;
}
