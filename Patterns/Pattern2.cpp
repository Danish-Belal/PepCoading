/*
1. You are given a number n.
2. You've to create a pattern of * and separated by tab as shown in output format.

Constraints

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
   for(int i = n-1 ; i >=0 ; i--){
        for(int j =0 ; j<= i ; j++){
             cout<<"*\t";
        }
        cout<<endl;
   }
   
  return 0;
}