// Find ncr.

#include<bits/stdc++.h>
using namespace std;

int factorial(int x)
{
     int xf =1;
     for(int i=1 ; i<=x ; i++){
          xf *=i; 
     }
     return xf;

}

int main()
{
     int n , r;
     cin>>n>>r;
     int nf= factorial(n);
     int cf = factorial(r);

     int nmrf = factorial(n-r);

     int ncr = nf / (cf*nmrf);
     cout<<ncr;
     

  return 0;
}