package SelfCode;

public class STACK {
    public static class Stack{
        int[] data ;
        int top;
        public Stack(int cap) {
            data = new int[cap];
            top = -1;
        }

        public void push(int val){
            if(top == data.length-1){
                System.out.println("STack Overflow");
                int[] oa = data;
                data = new int[oa.length *2];
                for(int i = 0 ; i<oa.length ; i++){
                    data[i] = oa[i];
                }
            }
                data[++top] = val;
        }

        int pop(){
            if(top == -1){
                System.out.println("Stack UnderFLow");
                return -1;
            }else{
                int val = data[top];
                top--;
                return val;
            }
        }

        void display(){
            for(int i = top ; i >= 0 ; i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

                  
    }
    public static void main(String[] args) {
        Stack st = new Stack(6);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        st.push(70);
        st.push(80);
        st.push(90);
        st.push(100);
        st.push(110);

        st.display();
        System.out.println(st.pop());
        st.push(70);
        st.display();


    }
}
