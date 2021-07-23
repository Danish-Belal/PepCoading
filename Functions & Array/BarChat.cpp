/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print a bar chart representing value of arr a.

Constraints

1 <= n <= 30
0 <= n1, n2, .. n elements <= 10

Sample Input

5
3
1
0
7
5

Sample Output

			*		
			*		
			*	*	
			*	*	
*			*	*	
*			*	*	
*	*		*	*	

*/

#include<bits/stdc++.h>
using namespace std;
int main()
{
   int n;
   cin>>n;
   int arr[n];
   for (int i = 0; i < n; i++)
   {
        cin>>arr[i];
   }
    for(int i = 0; i<n ; i++){
         for(int j =0 ; j< arr[i] ; j++){
              cout<<"*";
             
           
         }
          cout<<endl;
       
    }
   

   
  return 0;
}