package LeetCode;


import java.io.BufferedReader;

public class FindNthBitInKthString {
    public static  char findKthBit(int n, int k) {
        StringBuffer br=new StringBuffer("0");
        StringBuffer temp= new StringBuffer("");

       while(n !=0){
           temp = br;
           br.reverse();
         for(int i = 0 ; i<temp.length() ; i++){
             char ch = temp.charAt(i);
             if(ch == '0'){
                 temp.replace(i , i+1 , "1");
             }else{
                 temp.replace(i , i+1 , "0");
             }
         }
         br.append("1").append(temp);
         n--;

       }
       return br.charAt(k-1);


    }

    public static void main(String[] args) {
        int n = 20;
        int k = 11;
       char ch =findKthBit(n,k);
        System.out.println(ch);
    }
}
