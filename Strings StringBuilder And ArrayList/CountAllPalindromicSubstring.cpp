// Count all palendromic Substring.

#include <bits/stdc++.h>
using namespace std;
int Solution(string s)
{
     int ans = s.length();
     int count = 0;
     for (int idx = 0; idx < s.length(); idx++)
     {
          int left = idx - 1;
          int right = idx + 1;         
               while (left >=0 && right< s.length() && s.at(left) == s.at(right))
               {
                    left--;
                    right++;
                    ans +=1;
               }
               left = idx ; 
               right = idx+1;
                while (left >=0 && right< s.length() && s.at(left) == s.at(right))
               {
                    left--;
                    right++;
                    ans +=1;
               }

          
     }
     return ans;
}
int main()
{
     string s;
     cin >> s;

     int ans = Solution(s);
     cout << ans;

     return 0;
}