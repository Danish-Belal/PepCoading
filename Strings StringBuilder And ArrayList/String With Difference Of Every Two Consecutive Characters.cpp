/*
1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to form a string that contains the difference of ASCII values of every two 
consecutive characters between those characters.
   For "abecd", the answer should be "a1b3e-2c1d", as 
   'b'-'a' = 1
   'e'-'b' = 3
   'c'-'e' = -2
   'd'-'c' = 1

Constraints

1 <= length of string <= 1000

Sample Input

pepCODinG

Sample Output

p-11e11p-45C12O-11D37i5n-39G

*/
#include<bits/stdc++.h>
using namespace std;
string difference(string s)
{
    string ans = "";
    for(int i = 0 ; i<s.length() ; i++){
        // char c = s[i];
         ans = ans+s[i];
         if(i <s.length()-1){
         ans +=to_string(s[i+1]-s[i]);
         }
    }
    return ans;
}
int main()
{
     string s;
     cin >> s;

     string ans = difference(s);
     cout << ans;

     cout<<endl;
     


      
  return 0;
}