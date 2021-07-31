/*
1. You are given an ArrayList of positive integers.
2. You have to remove prime numbers from the given ArrayList and return the updated ArrayList.

Note -> The order of elements should remain same.

Constraints

1 <= N <= 10000

Sample Input

4
3 12 13 15

Sample Output

[12, 15]

*/

#include <bits/stdc++.h>
using namespace std;
bool isPrime(int n)
{
     for (int i = 2; i * i < n; i++)
     {
          if (n % i == 0)
          {
               return false;
          }
     }
     return true;
}
int main()
{
     int n;
     cin >> n;
     vector<int> v;
     int arr[n];

     for (int i = 0; i < n; i++)
     {
          cin >> arr[i];
     }

     for (int i = 0; i < n; i++)
     {
          //  cout<<arr[i]<<endl;
          bool b = isPrime(arr[i]);
          if (b == false)
          {
               v.push_back(arr[i]);
          }
     }
     cout << '[';
     for (int i = 0; i < v.size(); i++)
     {
          if (i == v.size() - 1)
          {
               cout << v[i];
          }
          else
          {
               cout << v[i] << ", ";
          }
     }
     cout << ']';

     return 0;
}