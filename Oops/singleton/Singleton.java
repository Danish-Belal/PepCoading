package Oops.singleton;

// Singleton class is a class which can create only one object.
public class Singleton {

    private  Singleton(){

    }
    private static Singleton instance;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}

/*
Singleton class is been used when we want to create only one object of that class.
we make constructor of that class as private and made instance of that class and create that once .
make that instance static so that we can not initialize that again and again.


 */
