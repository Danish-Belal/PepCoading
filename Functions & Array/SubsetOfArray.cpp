/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to print all subsets of arr. Each subset should be
on separate line. For more clarity check out sample input and output.

Constraints

1 <= n <= 10
0 <= n1, n2, .. n elements <= 10^3

Sample Input

3
10
20
30

Sample Output

-	-	-	
-	-	30	
-	20	-	
-	20	30	
10	-	-	
10	-	30	
10	20	-	
10	20	30	

*/
#include<bits/stdc++.h>
using namespace std;
int dtob(int n)
{
     int ans = 0 ;
     int power =1;
     while(n !=0){
          int r = n%2;
          n /=2;

          ans += (r*power);
          power *=10;
     }
     return ans;

}

void subSetOfArray(int *arr , int n){
     int power = pow(2,n);
   
     for(int i = 0 ; i< power ; i++){
          int bn =dtob(i);
       
         int n1=n-1;
          int div = pow(10 , n)/10;
      
         for(int j = 0 ;  j <n ; j++){
              int r = bn%div;
              int q = bn /div;
              if(q == 0 ){
                   cout<<"-"<<"\t";
              }else{
                   cout<<arr[j]<<"\t";
              }
              bn = r;
              div /=10;
         }
        cout<<endl;
     }
     
}

int main()
{
     int n;
     cin>>n;
     int arr[n];
     for(int i = 0 ; i< n ; i++){
          cin>>arr[i];
     }
     subSetOfArray(arr ,n);
  return 0;
}