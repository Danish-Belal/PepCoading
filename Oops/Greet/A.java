package Oops.Greet;
import static  Oops.B.Massage.massage;
/*
For accessing a package which is not present inside that package we need to import that file in that folder where we want to use it.
That function must should be public.
 */
public class A {
    public static void main(String[] args) {
        System.out.println("This is package A");
        massage();    // Accessing another function from different Package B .
    }
}
