package ArraysAndString2;

import java.util.Scanner;

public class tougle {

    static String toggleCase(String  s){
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i< s.length() ; i++){
            if(s.charAt(i) >= 'a' && s.charAt(i)<= 'z'){
                sb.append(s.charAt(i)-'a'+'A');
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                sb.append(s.charAt(i)-'A'+'a');
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }
}
