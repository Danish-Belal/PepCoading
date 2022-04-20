//package LeetCode;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class CloneGraph {
//    static class Node {
//        public int val;
//        public List<Node> neighbors;
//        public Node() {
//            val = 0;
//            neighbors = new ArrayList<Node>();
//        }
//        public Node(int _val) {
//            val = _val;
//            neighbors = new ArrayList<Node>();
//        }
//        public Node(int _val, ArrayList<Node> _neighbors) {
//            val = _val;
//            neighbors = _neighbors;
//        }
//    }
//
//    public Node cloneGraph(Node node) {
//        return null;
//
//    }
//
//    public static void main(String[] args){
//
//        Scanner scn = new Scanner(System.in);
//        int l = scn.nextInt();
//       // String s = scn.nextLine();
//        java.lang.String s = "dfghj";
//        System.out.println( print(s));
//    }
//
//    private static String print(String s) {
//        int n = 0 ;
//        int t = 0 ;
//
//        for(int i =0 ; i<s.length() ; i++){
//            char c = s.charAt(i);
//           if(c == 'N') n++;
//           else
//               t++;
//        }
//        return n> t ? "Nutan" : "Tusla";
//    }
//}
