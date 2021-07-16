/*
1. You've to count the number of digits in a number.
2. Take as input "n", the number for which the digits has to be counted.
3. Print the digits in that number.
*/
#include <iostream>
using namespace std;

int main(int argc, char **argv){
    int n;
    cin >> n;
    int count =0;
    while(n--){
        n /= 10;
        count++;
    }
    //write your code here
    cout<<count;
    
}