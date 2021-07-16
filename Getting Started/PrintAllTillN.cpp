/*
1. You've to print all prime numbers between a range. 
2. Take as input "low", the lower limit of range.
3. Take as input "high", the higher limit of range.
4. For the range print all the primes numbers between low and high (both included).

Input Format
low 
high

Output Format
n1
n2
.. all primes between low and high (both included)

*/

#include<bits/stdc++.h>
using namespace std;
int main()
{
   int low , high;
   cin>>low>>high;
   for( int i = low ; i<=high ; i++){
        int prime = 0;
        for(int j = 2 ; j*j <= i ; j++){
             if(i % j == 0 ){
                  prime++;
             }
        }
        if(!prime){
             cout<<i<<endl;
        }
   }
  return 0;
}