/*
1. You are given a string. 
2. You have to compress the given string in the following two ways - 
   First compression -> The string should be compressed such that consecutive 
   duplicates of characters are replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of 
   characters 
   are replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".


Constraints

1 <= length of string <= 1000

Sample Input

wwwwaaadexxxxxx

Sample Output

wadex
w4a3dex6

*/

#include <bits/stdc++.h>
using namespace std;
string stringCompression1(string s)
{
     string ans = "";
     ans += s[0];
     for (int i = 1; i < s.length(); i++)
     {
          char c = s[i];
          if (c != ans[ans.length() - 1])
          {
               ans += s[i];
          }
        
     }
     return ans;
}


string  stringCompression2(string s)
{
     string ans = "";
     ans += s[0];
     
     int ct = 1;
     for(int i = 1 ; i<s.length() ; i++){
          char c= s[i];
         
                   
          if(c == ans[ans.length()-1]){
               ct++;
          }else{
               if(ct >1){
               ans += to_string(ct);
               }
               ans += s[i];
                ct =1;
          }
        
     }
     if(ct>1){
          ans+=to_string( ct);
     }
    return ans;
}


int main()
{
     string s;
     cin >> s;

    string ans1 = stringCompression1(s);
    string ans2 = stringCompression2(s);

    cout << ans1<<endl;
    cout<<ans2<<endl;
   
    
     

     return 0;
}