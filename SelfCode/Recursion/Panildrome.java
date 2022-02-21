package SelfCode.Recursion;

public class Panildrome {
    static boolean palin(String s , int i){
        if(i >= s.length()/2) return true;
        if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        return palin(s , i+1);

    }
    public static void main(String[] args){
       String s = "MADAm";
       System.out.println(palin(s  ,0));
    }
}
