#include<bits/stdc++.h>
using namespace std;
/*
1. You are given a string. 
2. You have to print all palindromic substrings of the given string.


*/
bool isPalindrome(string s , int left , int right);

void Solution(string s){
     for(int si = 0 ; si<s.length() ; si++){
          for(int ei = si ; ei<s.length() ; ei++){
               if(isPalindrome(s , si , ei)==true){
                    cout<<s.substr(si , ei+1)<<endl;
               }
               
          }
     }
}


bool isPalindrome(string s , int left , int right){
     while(left < right){
          if(s[left] != s[right]){
               return false;
               break;

          }
          left++;
          right--;
     }
     return true;

}
int main()
{
     string st ;
     cin>>st;
    Solution(st);

  return 0;
}




/*
// Java Code.
import java.io.*;
import java.util.*;

public class Main {

	public static void Solution(String str){
	    for(int si = 0 ; si <str.length() ; si++){
	        for(int ei = si ; ei<str.length(); ei++){
	            if(isPalindrome(str , si , ei)==true){
	                System.out.println(str.substring( si , ei+1));
	            }
	        }
	    }
	}
	
    public static boolean isPalindrome(String s , int left , int right){
         while(left < right){
          if(s.charAt(left) != s.charAt(right)){
               return false;
             

          }
          left++;
          right--;
     }
     return true;
    }
public static void main(String[] args){
 Scanner scn = new Scanner(System.in);
 String str = scn.next();
  Solution(str);
    
   
}


*/