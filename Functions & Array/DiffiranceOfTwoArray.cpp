/*
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to find the difference of two numbers
 represented by two arrays and print the arrays. a2 - a1

Assumption - number represented by a2 is greater.

Constraints

1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
number reresented by a1 is smaller than number represented by a2

Sample Input
3
2 6 7
4
1 0 0 0

Sample Output

7 3 3
*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
     int n1;
     cin >> n1;
     int arr[n1];
     for (int i = 0; i < n1; i++)
     {
          cin >> arr[i];
     }
     int n2;
     cin >> n2;
     int arr2[n2];
     for (int i = 0; i < n2; i++)
     {
          cin >> arr2[i];
     }

     int mx = n2;
     int maxarr[n2];
     int borrow = 0;
     int i = n1 - 1;
     int j = n2 - 1;

     int ansi = mx - 1;

     while (ansi >= 0)
     {

          int diff = (arr2[j]-borrow);
          if(i>=0){
               diff -= arr[i];
          }
          if (diff < 0)
          {
               diff += 10;
               borrow =1;
                      
          }else{
               borrow =0;
          }
        
          maxarr[ansi] = diff;
        
          i--;
          j--;
          ansi--;
     }

     int k =0;
     while(maxarr[k] ==0){
          k++;
     }
  for(; k< mx ; k++){
       cout<<maxarr[k]<<" ";
  }  
     return 0;
}
