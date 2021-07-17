/*
1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Constraint
1 <= n <= 10

Sample Input
5

Sample Output

				*	
			*	*	
		*	*	*	
	*	*	*	*	
*	*	*	*	*	

*/

#include <iostream>
using namespace std;

int main(int argc, char **argv)
{
     int n;
     cin >> n;

     //write your code here
     int str = 1;
     int spc = n - 1;
   
     for (int i = 1; i <= n; i++)
     {

          for (int j = 1; j <= spc; j++)
          {
               cout << "\t";
          }
          for (int j = 1; j <= str; j++)
          {
               cout << "*\t";
          }
          cout << endl;
          str++;
          spc--;
     }
     return 0;
}