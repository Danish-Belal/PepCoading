/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the maximum of input. 
4. For the purpose complete the body of maxOfArray function. Don't change the signature.

Constraints

1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^9

Sample Input

6
15
30
40
4
11
9

Sample Output

40

*/
#include <iostream>
using namespace std;

int max(int arr[], int idx, int n , int max1){
    // write your code here
    
    if(idx >=n) return max1;
    
    if(arr[idx] > max1){
        max1 = arr[idx];
    }
  return max(arr , idx+1 , n , max1);
    
    
}

int main(){
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    
    int mx = INT8_MIN;
    int p = max(arr, 0, n , mx);
    cout << p << endl;
}
