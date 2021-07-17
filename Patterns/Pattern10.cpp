/*
1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Constraints

1 <= n <= 100
 Also, n is odd.

Sample Input

5

Sample Output

		*	
	*		*	
*				*	
	*		*	
		*	


*/
#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;

     int str =1;
     int spc = n/2;
     
     for (int i = 1; i <= n; i++)
     {
          for (int j = 1; j <= spc; j++)
          {
               cout << "\t";
          }
          for(int j = 1; j<=str ; j++){
               if( j == 1 || j== str){
               cout<<"*\t";}
               else{
                    cout<<"\t";
               }
          }

           
          if (i <= n / 2)
          {
               spc--;
               str += 2;
          }
          else
          {
                spc++;
               str -= 2;
          }

          cout << endl;
     }

     return 0;
}
