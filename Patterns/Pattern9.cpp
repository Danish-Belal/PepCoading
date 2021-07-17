/*

1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Constraints

1 <= n <= 100
 Also, n is odd.

Sample Input

5

Sample Output

*				*	
	*		*		
		*			
	*		*		
*				*	


*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
     int n;
     cin>>n;
     
     for(int i =1 ; i<=n ; i++){
          for(int j =1 ; j<=n; j++){
               if(i == j || i+j == n+1){
                    cout<<"*\t";
               }
               else{
                    cout<<"\t";
               }
          }
          cout<<endl;
     }

  return 0;
}