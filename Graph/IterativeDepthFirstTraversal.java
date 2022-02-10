package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/*
1. You are given a graph, and a source vertex.
2. You are required to do a iterative depth first traversal and print which vertex is reached via which
     path, starting from the source.

Note -> For output, check the sample output and question video. Iterative depth first traversal
               should mimic "Reverse preorder" i.e. nbr with highest value should be visited first and
               should be printed on the way down in recursion.
Constraints
None
Format
Input

Input has been managed for you
Output

Check the sample output
Example

Sample Input

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2

Sample Output

2@2
3@23
4@234
6@2346
5@23465
0@230
1@2301

 */
public class IterativeDepthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class pair{
        int vtrx;
        String psf;
        public pair(int v , String s){
            this.vtrx = v;
            this.psf = s;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        Stack<pair> S = new Stack<>();
        boolean[] visited = new boolean[vtces];

        dfs(graph , src , visited , S , ""+src);

    }

    static void dfs(ArrayList<Edge>[] graph , int src , boolean[] visited , Stack<pair> S , String ans){
      //  ans +=src;
        S.add(new pair(src , ans));

       while(S.size() !=0){
           pair rm = S.pop();

           if(!visited[rm.vtrx]) {
               visited[rm.vtrx] = true;
               System.out.println(rm.vtrx + "@" + rm.psf);
               for (Edge e : graph[rm.vtrx]) {
                   if (!visited[e.nbr]) {
                       S.add(new pair(e.nbr, rm.psf + e.nbr));
                   }
               }
           }
       }

    }
}
