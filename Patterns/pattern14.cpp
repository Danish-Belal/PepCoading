/*
1. You are given a number n.
2. You've to write code to print it's multiplication table up to 10 in format given below.


*/
#include<iostream>
using namespace std;
int main(int agrc, char** argv){
    int n;
    cin >> n;
    
    //write your code here
  
    
    for(int i =1 ; i<=10 ; i++){
        int t = i*n;
        cout<<n<<" * "<<i<<" = "<<t;
        cout<<endl;
    
    
        
    }
    
}