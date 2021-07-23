/*
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to add the numbers represented by two arrays and print the
arrays.

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10

Sample Input
5
3 1 0 7 5
6
1 1 1 1 1 1

Sample Output

1
4
2
1
8
6

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
     int mx = max(n1, n2) + 1;
     int maxarr[mx];
     int carry = 0;
     int i = n1 - 1;
     int j = n2 - 1;

     int ansi = mx - 1;

     while (ansi >= 0)
     {

          int sum = carry;
          if (i >= 0)
          {
               sum += arr[i];
          }
          if (j >= 0)
          {
               sum += arr2[j];
          }
          int r = sum % 10;
          int q = sum / 10;
          maxarr[ansi] = r;
          carry = q;
          i--;
          j--;
          ansi--;
     }

     for (int i = 0; i <= mx - 1; i++)
     {
          if (i == 0 && maxarr[i] == 0)
          {
          }
          else
          {
               cout << maxarr[i] << " ";
          }
     }

     return 0;
}