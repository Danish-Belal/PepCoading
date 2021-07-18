/*


Constraints

1 <= n <= 10
 Also, n is odd.

Sample Input

7

Sample Output

*	*	*	*	*	*	*	
	*				*	
		*		*	
			*	
		*	*	*	
	*	*	*	*	*	
*	*	*	*	*	*	*	

*/

#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;
     int str = n;
     int spc = 0;

     for (int i = 1; i <= n; i++)
     {
          for (int j = 1; j <= spc; j++)
          {
               cout << "\t";
          }
          for (int j = 1; j <= str; j++)
          {
               if (i > 1 && i <= n / 2 && j > 1 && j < str)
               {
                    cout << "\t";
               }
               else
               {
                    cout << "*\t";
               }
          }

          cout << endl;

          if (i <= n / 2)
          {
               str -= 2;
               spc++;
          }
          else
          {
               str += 2;
               spc--;
          }
     }

     return 0;
}