/*
1. You are given a number n.
2. You've to write code to print the pattern given in output format below

Constraints
1 <= n <= 10

Sample Input
7

Sample Output

1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1

*/
#include <bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin >> n;
     int spc = 2 * n - 3;
     int str = 1;

     for (int i = 1; i <= n; i++)
     {
          for (int j = 1; j <= str; j++)
          {
               cout << j<<"\t";
          }
          for (int j = 1; j <= spc; j++)
          {
               cout << "\t";
          }
          if (i == n)
          {
               str--;
          }
          for (int j = str; j >=1; j--)
          {
               cout <<j<< "\t";
          }
          spc -= 2;
          str++;

          cout << endl;
     }

     return 0;
}