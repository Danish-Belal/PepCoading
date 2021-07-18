/*

Constraints
1 <= n <= 10
 Also, n is odd.

Sample Input
5

Sample Output

		*	
		*	*	
*	*	*	*	*	
		*	*	
		*	

*/

#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;
     int str = 1;
     int spc = n / 2;
     for (int i = 1; i <= n; i++)
     {
          for (int j = 1; j <= spc; j++)
          {
               if (i == (n / 2) + 1)
               {
                    cout << "*\t";
               }
               else
               {
                    cout << "\t";
               }
          }
          for (int j = 1; j <= str; j++)
          {
               cout << "*\t";
          }

          if (i <= n / 2)
          {
               str++;
          }
          else
          {
               str--;
          }

          cout << endl;
     }

     return 0;
}