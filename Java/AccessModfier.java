package Java;

class Employee{
   private  String name;  // we can not access name directly so we will make a function to assignname.
    int age;
    int id;
    void getDetail(){
        System.out.println("Name->"+name + " age->"+age + " Id->"+id );
    }
    void getName(String s){
        name = s;
    }
}
public class AccessModfier {
    public static void main(String[] args){
        Employee emp = new Employee();
        emp.getName  ("Danish");
        emp.id = 31;
        emp.age = 21;
        emp.getDetail();

    }
}
