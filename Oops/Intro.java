package Oops;

public class Intro {
     static  class Student{
        int roll;
        String name;
        String Class ;

         public void diaplay() {
             System.out.println(this.name);
             System.out.println(this.roll);
             System.out.println(this.Class);
         }
     }



    public static void main(String[] args) {
        Student st1 = new Student();
        st1.roll = 10;
        st1.name = "Danish";
        st1.Class = "B.tech";

        st1.diaplay();

    }
}
