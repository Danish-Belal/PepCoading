/*
In a country of novice government, 
the economic system is changed where only coins are used that too of various denominations.
 Whenever a foreigner visits this country,
  they visit a money exchanger to get the currency of the same country.
   As the foreigner is unaware of the denomination of the country, 
   the money exchange prefers to tell them the denomination which is the nearest
    maximum and nearest minimum to the denomination mentioned by the foreigner. 
    In case they get the correct guess of the denomination, they are told the same denomination.
     The denominations are always quoted in ascending order.

Example 1: In a country, 8 given denominations are as follows
[5, 10, 15, 22, 33, 40, 42, 55]

The foreigner asks for denomination 25.
The money exchange tells them that denominations of 33 and 22 are available.

Example 2: 
In a country, 5 given denominations are as follows
[7, 14, 18, 25, 30]

The foreigner asks for the denomination of 18.

The money exchange tells them a denomination of 18 is available.  

You are required to print the values told by the money exchange to the foreigner.

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of the array a.
3. You are given another number d.
4. You are required to find the ceil and floor of d in array a.

Constraints

1 <= n <= 1000
-10^9 <= n1, n2, .. n elements <= 10^9
-10^9 <= d <= 10^9

Sample Input

10
1
5
10
15
22
33
40
42
55
66
34

Sample Output

40
33

*/

#include <bits/stdc++.h>
using namespace std;

int searchElement(int *arr, int n,  int d)
{
     int l = 0;
     int r = n-1;
    int celli =-1;
    int  floor =-1;
     while (l <= r)
     {
          int mid = l+ ( r-l) / 2;
          
          if (arr[mid] == d)
          {
               return d;
          }
          else if (arr[mid] < d)
          {
               l = mid+1;
               floor =arr[mid];
          }
          else
          {
               r = mid-1;
               celli = arr[mid];
          }
     }
    
     cout<<celli<<endl<<floor<<endl;
     return -1;


}
int main()
{
     int n;
     cin >> n;
     int arr[n];
     for (int i = 0; i < n; i++)
     {
          cin >> arr[i];
     }

     int d;
     cin >> d;
  
  int i =   searchElement(arr, n,  d);
  if(i < 0){
       
  }else{
       cout<<i;
  }

     return 0;
}