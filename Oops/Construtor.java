package Oops;

public class Construtor {

   public static void main(String[] args) {
//        Student D = new Student();
//        System.out.println(D.name);
//        System.out.println(D.roll);
//        System.out.println(D.marks);
//
//        D.greet();
//
//        Student  Para = new Student(10 , "Belal" , 87.6f);
//        System.out.println(Para.name);
//        System.out.println(Para.roll);
//        System.out.println(Para.marks);


       Student s = new Student();
       s.display();

       Student other = new Student(s);
       other.display();


    }
}


class Student{
    int roll ;
    String name;
    float marks;

//    Student(){
//        this.name = "Danish Belal";
//        this.marks = 78.54f;
//        this.roll = 10;
//    }

    void greet(){
        System.out.println("Hello Mister " + this.name);
    }
    void display(){
        System.out.println(this.name);
        System.out.println(this.roll);
        System.out.println(this.marks);
    }
    Student(int roll , String name , float marks){    // Parametrized Constructor.
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    Student(){
        this(13,"Zishan Jawed" , 87.6f);
    }

    Student(Student other){
        this.name = other.name;
        this.roll = other.roll;
        this.marks = other.marks;
    }
}
