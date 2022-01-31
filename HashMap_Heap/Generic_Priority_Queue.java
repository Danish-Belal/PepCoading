package HashMap_Heap;

import java.util.ArrayList;

public class Generic_Priority_Queue {
    public static class Student implements Comparable<Student>{
        String name ;
        int h;
        int w;
        int roll;
        Student(String s , int h , int w , int r){
            this.name = s;
            this.h = h;
            this.w = w;
            this.roll = r;
        }

        public int compareTo(Student s1){
            return this.h-s1.h;
        }
        public String toString(){
            return "["+this.name+ " ]"+" -> " + "Hight = "+ this.h + " , Weight = "+this.w+",  Roll="+this.roll+".";
        }
    }

    public static class MyPriorityQueue<T> {
        ArrayList<T> data ;


        public MyPriorityQueue(){
            data = new ArrayList<>();
        }

        public void add(T val){
            data.add(val);
            heapfy(data.size()-1);
        }

        boolean isSmaller(int i , int j){

            Comparable  ith =(Comparable) data.get(i);
            Comparable  jth =(Comparable) data.get(j);

            if(ith.compareTo(jth) <0){
                return true;
            }else{
                return false;
            }

        }
        void heapfy(int ci){
            if(ci == 0 ){
                return ;
            }
            int pi = (ci-1 )/2;
            if(isSmaller(ci , pi)){
                swap(ci , pi);
                heapfy(pi);
            }
        }
        public void swap(int i , int j){
            T ith = data.get(i);
            T jth = data.get(j);
            data.set( i , jth);
            data.set( j , ith);
        }

        public T remove(){
            if(data.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            swap(0 , data.size()-1);
            T ans = data.remove(data.size()-1);
            downheapfy(0);
            return ans;
        }

        public void downheapfy(int pi){

            int li = 2*pi +1;
            int ri = 2*pi +2;

            int minidx = pi;
            if(li < data.size()-1 && isSmaller(li , minidx)){
                minidx = li;
            }
            if(ri < data.size()-1 && isSmaller(ri , minidx)){
                minidx = ri;
            }

            if(minidx != pi){
                swap(minidx, pi);
                downheapfy(minidx);
            }
        }

        public T peek(){
            if(data.size() == 0){
                System.out.println("Underflow");
                return null;
            }
            return data.get(0);
        }

        public int size(){
            return data.size();
        }
    }
    public static void main(String[] args){

        MyPriorityQueue<Student> mpq = new MyPriorityQueue();
        mpq.add(new Student("A" , 156 , 70 , 1));
        mpq.add(new Student("B" , 176 , 60 , 5));
        mpq.add(new Student("C" , 196 , 80 , 7));
        mpq.add(new Student("D" , 189 , 820 ,3));

        while(mpq.size() > 0){
            System.out.println(mpq.remove());
        }
    }
}
