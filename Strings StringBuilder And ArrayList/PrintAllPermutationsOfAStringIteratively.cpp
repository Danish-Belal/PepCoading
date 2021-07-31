/*
1. You are given a string. 
2. You have to print all permutations of the given string iteratively.

Constraints

1 <= length of string <= 15

Sample Input

abc

Sample Output

abc
bac
cab
acb
bca
cba

// Permutations Are combinations of all possible set , if there are three alue then permutations are n!.

*/
#include <bits/stdc++.h>
using namespace std;

void solution(string str)
{
   	int fn = 1;
		
		for(int i =2 ; i<=str.length(); i++){
		    fn *=i;
		}
		cout<<fn<<endl;
		
		// System.out.println(fn);
		for(int i = 0 ; i<fn ; i++){
		    int n = i;
		    int div = str.length();
		    string sb = str;
              string ans = "";
		    
		    while(div >=1){
		        int q = n/div;
		        int r = n%div;
		        ans +=sb[r];
			   sb.erase(r,r-1);
		       
		        n =q;
		        div--;
		        
		        
		    }
		  cout<<ans<<endl;
		}
		
		
}

// Strings are immutable;
int main()
{
     string s;
     cin >> s;
       solution(s);

     return 0;
}

/*
import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str){
		// write your code here
		int fn = 1;
		
		for(int i =2 ; i<=str.length(); i++){
		    fn *=i;
		}
		
		// System.out.println(fn);
		for(int i = 0 ; i<fn ; i++){
		    int n = i;
		    int div = str.length();
		    StringBuffer sb = new StringBuffer(str);
		    
		    while(div >=1){
		        int q = n/div;
		        int r = n%div;
		        System.out.print(sb.charAt(r));
		        sb.deleteCharAt(r);
		        n =q;
		        div--;
		        
		        
		    }
		    System.out.println();
		}
		
		
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}






*/