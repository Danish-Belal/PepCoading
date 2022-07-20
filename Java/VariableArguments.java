package Java;

public class VariableArguments {
    public static void main(String[] args){
        System.out.println(add(1,2,3,4,5,6,5,3,4,2,3,4,2,2));
    }
    // How many argument are coming put it in arr and then represent.
    static int add(int x ,int ...arr){ // x rep it should have one value.
        // Available as int[] arr.
          int sum =x;
          for(int i : arr) sum +=i;
          return sum;
         }
}
