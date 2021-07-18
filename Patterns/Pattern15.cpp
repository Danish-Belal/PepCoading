/*
1. You are given a number n.
2. You've to write code to print the pattern given in output format below.

Constraints

1 <= n <= 10
 Also, n is odd.

Sample Input

5

Sample Output

		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	


*/
#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;
     int num = 1;
     int spc = n / 2;
     int n1 = 1;
     for (int i = 1; i <= n; i++)
     {
          int n2 = n1;
          for (int j = 1; j <= spc; j++)
          {
               cout << "\t";
          }
          for (int j = 1; j <= num; j++)
          {

               // cout<<"*"<<"\t";
              
               cout << n2 << "\t";
               if(j <= num/2){
                  n2++;  

               }
               else{
                    n2--;
               }
               
              

              
          }
         

          if (i <= n / 2)
          {
               spc--;
               num += 2;
                 n1++;
          }
          else
          {
               spc++;
               num -= 2;
                n1--;
          }

          cout << endl;
     }

     return 0;
}