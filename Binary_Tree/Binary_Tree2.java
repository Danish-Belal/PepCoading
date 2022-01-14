package Binary_Tree;

import java.util.Stack;


public class Binary_Tree2 {
    public static class pair{
        Node  node;
        int state;
       public pair( Node node , int state){
            this.state = state;
            this.node = node;
        }
    }
    public  static class Node{
        int data;
        Node left;
        Node right;
      public  Node(){
        }

      public  Node(int val , Node left , Node right){
            this.data = val;
            this.left = left;
            this.right = right;
        }

    }
    public  static Node create(Integer[] arr){
        Node root = new Node(arr[0] , null , null);
       Stack<pair> s = new Stack<>();

       s.push(new pair(root , 0));
      for(int i =1 ; i<arr.length ; i++){
          if(arr[i] == null){
              s.peek().state++;
              if(s.peek().state == 2){
                  s.pop();
              }
          }else{
              Node nn= new Node(arr[i] , null , null);
              pair tos = s.peek();
              if(tos.state == 1){
                  tos.node.left = nn;
              }else{
                  tos.node.right = nn;
              }
              tos.state++;
              if(tos.state == 2){
                  s.pop();
              }
              s.push(new pair(nn , 0));
          }
      }
      return root;

    }

    static void display(Node root){

    }

    public static void main(String[] args) {
        Integer[] arr = {10,20,40,null , 80,null,null,50,null,null , 30,null , 60,70,null,null , null};
        create(arr);

    }
}
