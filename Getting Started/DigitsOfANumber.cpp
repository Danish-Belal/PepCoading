/*
1. You've to display the digits of a number.
2. Take as input "n", the number for which digits have to be displayed.
3. Print the digits of the number line-wise.

*/
#include <bits/stdc++.h>
using namespace std;

int main()
{
     int n;
     cin >> n;
     vector<int> v;
     while (n > 0)
     {
          int ld = n % 10;
          v.push_back(ld);
         // cout << ld << endl;
          n /= 10;
     }
    for(int i = v.size()-1 ; i >= 0; i--){
         cout<<v[i]<<endl;

    }
}
