package LeetCode;

public class AddBinary {
    public static String addBinary(String a, String b) {

        StringBuilder ans = new StringBuilder();
        int i = a.length()-1 ;
        int j = b.length()-1;
        int carry = 0;

        while (i >= 0 || j >=0){

           int c1 = (i >=0) ? a.charAt(i)-'0' : 0;
           int c2 = (j >=0) ? a.charAt(j)-'0' : 0;

            int sum = c1+c2+carry;

           ans.append(sum%2);
           carry = sum/2;
            i--;
            j--;
        }
        if(carry != 0) ans.append(carry);
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String res= addBinary("11" , "1");
        System.out.println(res);
    }
}
