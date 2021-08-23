package RecursionWithArrayList;
import java.sql.SQLOutput;
import java.util.*;
public class GetSubSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.println(gss(s));

    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>() ;
            base.add("");
            return base;
        }

        char c = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = gss(ros);
        ArrayList<String> mr = new ArrayList<String>();

        mr.addAll(rr);
        for (int i=0 ; i<rr.size(); i++){
            mr.add(c+ rr.get(i));
        }

      return  mr ;
    }

}
