/*
1.You are given a number n, representing the size of array a.
2.You are given n distinct numbers, representing elements of array a.
3. You are given another number d.
4. You are required to check if d number exists in the array a and at what index (0 based).
 If found print the index, otherwise print -1.
Constraints

1 <= n <= 10^7
-10^9 <= n1, n2 
.. n elements <= 10^9
-10^9 <= d <= 10^9

Sample Input
6
15
30
40
4
11
9
40

Sample Output

2

*/
#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long int n;
     cin>>n;
    long long int arr[n];
    for(int i=0 ; i<n;i++){
         cin>>arr[i];
    }
    int found , find =0;
    int key ;
    cin>>key;
    for(int i = 0 ; i< n ;i++){
         if(arr[i] == key){
              found = i;
              find = 1;
         }
    }
    if(find){
         cout<<found;
    }
    else{
         cout<<-1;
    }

  return 0;
}