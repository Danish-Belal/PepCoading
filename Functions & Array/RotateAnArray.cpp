/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. Rotate the array a, k times to the right (for positive values of k), and to
the left for negative values of k.

Constraints

0 <= n < 10^4
-10^9 <= a[i], k <= 10^9

Sample Input

5
1 2 3 4 5
3

Sample Output

3 4 5 1 2

*/

#include<iostream>
using namespace std;

void reverse(int *arr, int n, int i , int j);
void rotate(int *arr, int n, int k){
   
   k = k%n;
   if(k < 0){
        k += n;
   }
   reverse(arr ,n, 0 , n-1);
    reverse(arr ,n, 0 , k-1);
    reverse(arr ,n,  k , n-1);
   
    
}

void reverse(int *arr, int n, int i , int j){
 
   while(j >= i){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
       j-- ;
       i++;
   }
   
}


void display(int* arr, int n){
    for(int i = 0 ; i < n; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int main(){
    int n, r;
    cin>>n;
    int* arr = new int[n];
    for(int i = 0 ; i < n; i++){
        cin>>arr[i];
    }
    cin>>r;
    
    rotate(arr,n,r);
    display(arr,n);
}