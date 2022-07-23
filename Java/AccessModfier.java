package Java;

class Employee{
    String name;
    int age;
    int id;
    void getDetail(){
        System.out.println("Name->"+name + " age->"+age + " Id->"+id );
    }
}
public class AccessModfier {
    public static void main(String[] args){
        Employee emp = new Employee();
        emp.name = "Danish";
        emp.id = 31;
        emp.age = 21;
        emp.getDetail();

    }
}
