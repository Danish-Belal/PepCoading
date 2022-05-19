/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to reverse the contents of array a.

Constraints

0 <= n < 10^4
-10^9 <= a[i] <= 10^9

Sample Input

5
1
2
3
4
5

Sample Output

5 4 3 2 1


*/
#include<iostream>
using namespace std;

void reverse(int* arr, int n , int i , int j){
 
   while(j >= i){
       int temp = arr[i];
       arr[i++] = arr[j];
       arr[j--] = temp;
//       j-- ;
//       i++;
   }
   
}

void display(int* arr, int n){
    for(int i = 0 ; i < n; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main(){
    int n;
    cin>>n;
    
    int* arr = new int[n];
    for(int i = 0 ; i < n; i++){
        cin>>arr[i];
    }
    reverse(arr,n , 0 , n-1);
    display(arr,n);
}