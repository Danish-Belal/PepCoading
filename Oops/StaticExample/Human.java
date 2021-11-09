package Oops.StaticExample;
/*
Static is Property or method of a class which is same for every one.
Not dependent on Object that is known as static method or static variable.
Static Depends on class not on object.
Static Method can only access Static Data , it can not Access Non-Static Data.
 */

public  class Human {
    int age;
    String name;
    char gender;
    boolean married;
    static int  population;

    public static void massage(){
        System.out.println("Hello World");
//        System.out.println(this.age);  // can not use this over here , this is static .
    }

    public Human(int age, String name, char gender, boolean married) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.married = married;
        Human.population +=1;
    }
    public  void display(){
        System.out.println(this.age);
        System.out.println(this.name);
        System.out.println(this.gender);
        System.out.println(this.married);

    }
}



