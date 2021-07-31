/*
1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to toggle the case of every character of the given string.

Constraints

1 <= length of string <= 1000

Sample Input

pepCODinG

Sample Output

PEPcodINg

*/

#include <bits/stdc++.h>
using namespace std;
string toggle(string s)
{
     string ans = "";
     for (int i = 0; i < s.length(); i++)
     {
          char c = s[i];
          if (c >= 65 && c <= 90)
          {
               c = c +32;
          }
          else if(c >=97 && c<=121)
          {
               c = c -32;
          }
          ans += c;
     }
     return ans;
}

int main()
{
     string s;
     cin >> s;

     string ans = toggle(s);
     cout << ans;

     return 0;
}