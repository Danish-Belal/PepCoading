/*
1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Constrain
1 <= n <= 100

Sample Input
5

Sample Output

*	*	*	*	*	
	*	*	*	*	
		*	*	*	
			*	*	
				*
*/

#include<bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin>>n;
     int str = n;
     int spc =0; 
     for(int i =1 ; i <=n ; i++){
          for(int j =1 ; j<=spc ; j++){
               cout<<"\t";
          }
          for(int j =1 ; j<=str ; j++){
               cout<<"*\t";
          }
          cout<<endl;
          spc++;
          str--;

     }

  return 0;
}